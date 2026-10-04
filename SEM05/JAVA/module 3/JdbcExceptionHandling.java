// Develop a JDBC application that handles connection errors, invalid SQL queries, duplicate records and invalid input using appropriate exception handling.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;
public class JdbcExceptionHandling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            try {
                st.executeUpdate("INSERT INTO students (id, name, marks) VALUES (1, '" + name + "', " + marks + ")");
                System.out.println("Inserted.");
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Duplicate record.");
            }
            try {
                st.executeQuery("SELECT * FORM students");
            } catch (SQLException e) {
                System.out.println("Invalid SQL query.");
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection.");
            }
            System.out.println("Exception handling completed.");
        }
        sc.close();
    }
}
