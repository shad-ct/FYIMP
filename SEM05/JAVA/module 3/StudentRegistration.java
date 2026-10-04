// Develop a student registration program using PreparedStatement to insert and search student records based on user input.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class StudentRegistration {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            ps.execute();
            ps.close();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();
            PreparedStatement ins = con.prepareStatement("INSERT INTO students (name, marks) VALUES (?, ?)");
            ins.setString(1, name);
            ins.setDouble(2, marks);
            ins.executeUpdate();
            System.out.println("Student registered.");
            ins.close();
            System.out.print("Enter name to search: ");
            String key = sc.nextLine();
            PreparedStatement sel = con.prepareStatement("SELECT * FROM students WHERE name = ?");
            sel.setString(1, key);
            ResultSet rs = sel.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("marks"));
            }
            rs.close();
            sel.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
