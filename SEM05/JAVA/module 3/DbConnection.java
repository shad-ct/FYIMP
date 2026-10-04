// Write a Java program to connect to a MySQL database using JDBC and display a successful connection message.
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to database successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
