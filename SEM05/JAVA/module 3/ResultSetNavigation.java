// Retrieve employee/student records and demonstrate ResultSet navigation methods such as next(), previous(), first(), last() and absolute().
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ResultSetNavigation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement setup = con.createStatement();
            setup.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            setup.close();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            System.out.println("Forward:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
            rs.first();
            System.out.println("First: " + rs.getString("name"));
            rs.last();
            System.out.println("Last: " + rs.getString("name"));
            rs.previous();
            System.out.println("Previous: " + rs.getString("name"));
            rs.absolute(1);
            System.out.println("Absolute(1): " + rs.getString("name"));
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
