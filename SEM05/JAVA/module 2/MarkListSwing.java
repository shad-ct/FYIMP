// Create a Swing application to accept the name, register number, and marks in three subjects using text fields. Calculate total, average, and grade. Display the result using JLabel or JTextArea. Use JButton for Calculate, Clear, and Exit operations. Validate that the entered marks are within the range 0-100.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
public class MarkListSwing {
    public static void main(String[] args) {
        JFrame f = new JFrame("Mark List");
        f.setSize(400, 400);
        f.setLayout(new GridLayout(9, 2));
        JTextField nameField = new JTextField();
        JTextField regField = new JTextField();
        JTextField s1 = new JTextField();
        JTextField s2 = new JTextField();
        JTextField s3 = new JTextField();
        JTextArea output = new JTextArea();
        JButton calc = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JButton exit = new JButton("Exit");
        f.add(new JLabel("Name:"));
        f.add(nameField);
        f.add(new JLabel("Reg No:"));
        f.add(regField);
        f.add(new JLabel("Mark1:"));
        f.add(s1);
        f.add(new JLabel("Mark2:"));
        f.add(s2);
        f.add(new JLabel("Mark3:"));
        f.add(s3);
        f.add(calc);
        f.add(clear);
        f.add(exit);
        f.add(output);
        calc.addActionListener(e -> {
            try {
                int a = Integer.parseInt(s1.getText());
                int b = Integer.parseInt(s2.getText());
                int c = Integer.parseInt(s3.getText());
                if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                    output.setText("Marks must be 0-100.");
                    return;
                }
                int total = a + b + c;
                double avg = total / 3.0;
                String grade = "F";
                if (avg >= 90) grade = "A";
                else if (avg >= 75) grade = "B";
                else if (avg >= 60) grade = "C";
                else if (avg >= 40) grade = "D";
                output.setText("Total: " + total + "\nAverage: " + avg + "\nGrade: " + grade);
            } catch (NumberFormatException ex) {
                output.setText("Invalid input.");
            }
        });
        clear.addActionListener(e -> {
            nameField.setText("");
            regField.setText("");
            s1.setText("");
            s2.setText("");
            s3.setText("");
            output.setText("");
        });
        exit.addActionListener(e -> System.exit(0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
