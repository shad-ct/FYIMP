// Create a MySQL stored procedure and invoke it from Java using CallableStatement.
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StoredProcedureDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            st.executeUpdate("DROP PROCEDURE IF EXISTS get_students");
            st.executeUpdate("CREATE PROCEDURE get_students() BEGIN SELECT * FROM students; END");
            CallableStatement cs = con.prepareCall("{CALL get_students()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("marks"));
            }
            rs.close();
            cs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
