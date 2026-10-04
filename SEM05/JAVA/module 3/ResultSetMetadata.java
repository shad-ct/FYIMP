// Display the column names, column count, data types and other properties of a table dynamically using ResultSetMetaData.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class ResultSetMetadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            ResultSetMetaData md = rs.getMetaData();
            System.out.println("Column count: " + md.getColumnCount());
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.println(md.getColumnName(i) + " " + md.getColumnTypeName(i) + " " + md.getColumnDisplaySize(i));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
