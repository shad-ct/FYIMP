// Write a program to display database information such as database name, version, driver name, supported features and available tables using DatabaseMetaData.
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class DatabaseMetadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            DatabaseMetaData md = con.getMetaData();
            System.out.println("Database: " + md.getDatabaseProductName());
            System.out.println("Version: " + md.getDatabaseProductVersion());
            System.out.println("Driver: " + md.getDriverName());
            System.out.println("Driver Version: " + md.getDriverVersion());
            System.out.println("Supports transactions: " + md.supportsTransactions());
            ResultSet rs = md.getTables("college_db", null, "%", new String[]{"TABLE"});
            System.out.println("Tables:");
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
