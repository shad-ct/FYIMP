// Design a Java Swing application containing JLabel, JTextField, JPasswordField, and JButton components to create a Login Form. Accept username and password. Verify the entered credentials against predefined values. Display appropriate success or error messages using JOptionPane. Include Reset and Exit buttons. Ensure that the password is not displayed as plain text.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
public class LoginForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login Form");
        f.setSize(300, 200);
        f.setLayout(new GridLayout(4, 2));
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton login = new JButton("Login");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        f.add(new JLabel("Username:"));
        f.add(userField);
        f.add(new JLabel("Password:"));
        f.add(passField);
        f.add(login);
        f.add(reset);
        f.add(exit);
        login.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(f, "Login successful.");
            } else {
                JOptionPane.showMessageDialog(f, "Invalid credentials.");
            }
        });
        reset.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
        });
        exit.addActionListener(e -> System.exit(0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
