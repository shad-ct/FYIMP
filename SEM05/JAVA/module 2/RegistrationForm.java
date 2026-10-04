// Develop a Java AWT application for a Student Registration Form using Frame, Panel, Label, TextField, Choice, Checkbox, and Button. Use appropriate layout managers to organize the components neatly. The application should include Submit and Clear buttons and display the entered details when Submit is clicked.
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class RegistrationForm extends Frame implements ActionListener {
    TextField nameField;
    TextField rollField;
    Choice courseChoice;
    Checkbox c1;
    Checkbox c2;
    TextArea output;
    Button submit;
    Button clear;
    RegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2));
        add(new Label("Name:"));
        nameField = new TextField();
        add(nameField);
        add(new Label("Roll No:"));
        rollField = new TextField();
        add(rollField);
        add(new Label("Course:"));
        courseChoice = new Choice();
        courseChoice.add("BCA");
        courseChoice.add("MCA");
        courseChoice.add("BSc");
        add(courseChoice);
        add(new Label("Subjects:"));
        Panel p = new Panel();
        c1 = new Checkbox("Java");
        c2 = new Checkbox("Python");
        p.add(c1);
        p.add(c2);
        add(p);
        submit = new Button("Submit");
        clear = new Button("Clear");
        add(submit);
        add(clear);
        output = new TextArea(4, 30);
        add(output);
        submit.addActionListener(this);
        clear.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            output.setText("Name: " + nameField.getText() + "\nRoll: " + rollField.getText() + "\nCourse: " + courseChoice.getSelectedItem());
        } else {
            nameField.setText("");
            rollField.setText("");
            output.setText("");
        }
    }
    public static void main(String[] args) {
        new RegistrationForm();
    }
}
