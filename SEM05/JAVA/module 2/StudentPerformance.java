// Design and implement a Student Performance Management System using Java AWT. The interface should contain text fields for student details, controls for entering marks, buttons for calculating total and average, and a suitable component for displaying the result. Use Frame, Panel, appropriate layout managers, AWT controls, and event listeners. Include suitable window-closing event handling using an adapter class.
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class StudentPerformance extends Frame implements ActionListener {
    TextField nameField;
    TextField m1;
    TextField m2;
    TextField m3;
    TextArea output;
    Button calc;
    StudentPerformance() {
        setTitle("Student Performance");
        setSize(400, 350);
        setLayout(new GridLayout(7, 2));
        add(new Label("Name:"));
        nameField = new TextField();
        add(nameField);
        add(new Label("Mark1:"));
        m1 = new TextField();
        add(m1);
        add(new Label("Mark2:"));
        m2 = new TextField();
        add(m2);
        add(new Label("Mark3:"));
        m3 = new TextField();
        add(m3);
        calc = new Button("Calculate");
        add(calc);
        output = new TextArea(4, 30);
        add(output);
        calc.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(m1.getText());
            int b = Integer.parseInt(m2.getText());
            int c = Integer.parseInt(m3.getText());
            int total = a + b + c;
            double avg = total / 3.0;
            output.setText("Name: " + nameField.getText() + "\nTotal: " + total + "\nAverage: " + avg);
        } catch (NumberFormatException ex) {
            output.setText("Invalid marks.");
        }
    }
    public static void main(String[] args) {
        new StudentPerformance();
    }
}
