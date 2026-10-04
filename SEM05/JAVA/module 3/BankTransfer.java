// Implement a bank money-transfer system using JDBC transactions. Use commit() when successful and rollback() when an error occurs.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class BankTransfer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (id INT PRIMARY KEY, balance DOUBLE)");
            st.executeUpdate("INSERT INTO accounts (id, balance) VALUES (1, 1000), (2, 500) ON DUPLICATE KEY UPDATE balance = VALUES(balance)");
            st.close();
            try {
                PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance = balance - 200 WHERE id = 1");
                debit.executeUpdate();
                debit.close();
                PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance = balance + 200 WHERE id = 2");
                credit.executeUpdate();
                credit.close();
                con.commit();
                System.out.println("Transfer successful.");
            } catch (Exception e) {
                con.rollback();
                System.out.println("Transfer failed, rolled back.");
            }
            Statement q = con.createStatement();
            ResultSet rs = q.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println("Account " + rs.getInt("id") + ": " + rs.getDouble("balance"));
            }
            rs.close();
            q.close();
            con.setAutoCommit(true);
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
