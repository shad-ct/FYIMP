// Store and retrieve an image using BLOB and a large text/document using CLOB.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class BlobClobDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS documents (id INT PRIMARY KEY AUTO_INCREMENT, image LONGBLOB, content LONGTEXT)");
            st.executeUpdate("DELETE FROM documents");
            st.close();
            File imgFile = new File("sample_image.png");
            File docFile = new File("sample_doc.txt");
            FileInputStream fis = new FileInputStream(imgFile);
            FileReader fr = new FileReader(docFile);
            PreparedStatement ins = con.prepareStatement("INSERT INTO documents (image, content) VALUES (?, ?)");
            ins.setBinaryStream(1, fis, (int) imgFile.length());
            ins.setCharacterStream(2, fr, (int) docFile.length());
            ins.executeUpdate();
            ins.close();
            fis.close();
            fr.close();
            System.out.println("Stored BLOB and CLOB.");
            PreparedStatement sel = con.prepareStatement("SELECT * FROM documents");
            ResultSet rs = sel.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream("image");
                FileOutputStream fos = new FileOutputStream("retrieved_image.png");
                byte[] buf = new byte[4096];
                int n;
                while ((n = is.read(buf)) != -1) {
                    fos.write(buf, 0, n);
                }
                fos.close();
                is.close();
                Reader r = rs.getCharacterStream("content");
                FileWriter fw = new FileWriter("retrieved_doc.txt");
                char[] cbuf = new char[4096];
                int m;
                while ((m = r.read(cbuf)) != -1) {
                    fw.write(cbuf, 0, m);
                }
                fw.close();
                r.close();
                System.out.println("Retrieved BLOB and CLOB.");
            }
            rs.close();
            sel.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
