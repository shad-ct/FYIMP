// Create a student database/table and implement INSERT, UPDATE, DELETE and SELECT operations using JDBC Statement.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentCrud {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            st.executeUpdate("DELETE FROM students");
            st.executeUpdate("INSERT INTO students (name, marks) VALUES ('Amit', 85), ('Ravi', 72)");
            st.executeUpdate("UPDATE students SET marks = 90 WHERE name = 'Amit'");
            st.executeUpdate("DELETE FROM students WHERE name = 'Ravi'");
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("marks"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
