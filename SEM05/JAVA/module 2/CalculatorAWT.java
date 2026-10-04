// Create a Simple Calculator using Java AWT. Use TextField components for input and Button controls for addition, subtraction, multiplication, and division. Implement event handling using ActionListener. Handle invalid input and division-by-zero situations appropriately.
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class CalculatorAWT extends Frame implements ActionListener {
    TextField t1;
    TextField t2;
    Label result;
    Button add;
    Button sub;
    Button mul;
    Button div;
    CalculatorAWT() {
        setTitle("AWT Calculator");
        setSize(350, 200);
        setLayout(new FlowLayout());
        t1 = new TextField(10);
        t2 = new TextField(10);
        add(t1);
        add(t2);
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        add(add);
        add(sub);
        add(mul);
        add(div);
        result = new Label("Result: ");
        add(result);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            if (e.getSource() == add) {
                result.setText("Result: " + (a + b));
            } else if (e.getSource() == sub) {
                result.setText("Result: " + (a - b));
            } else if (e.getSource() == mul) {
                result.setText("Result: " + (a * b));
            } else {
                if (b == 0) {
                    result.setText("Division by zero.");
                } else {
                    result.setText("Result: " + (a / b));
                }
            }
        } catch (NumberFormatException ex) {
            result.setText("Invalid input.");
        }
    }
    public static void main(String[] args) {
        new CalculatorAWT();
    }
}
