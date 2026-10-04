// Develop an AWT-based Color Selection Application containing buttons or other suitable controls for selecting different colors. When the user selects a color, change the background color of the Panel or Frame. Identify and use the appropriate event source, event class, and listener interface for handling the user actions.
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class ColorSelection extends Frame implements ActionListener {
    Panel panel;
    Button redBtn;
    Button greenBtn;
    Button blueBtn;
    ColorSelection() {
        setTitle("Color Selection");
        setSize(300, 200);
        setLayout(new FlowLayout());
        panel = new Panel();
        panel.setSize(250, 100);
        redBtn = new Button("Red");
        greenBtn = new Button("Green");
        blueBtn = new Button("Blue");
        add(redBtn);
        add(greenBtn);
        add(blueBtn);
        add(panel);
        redBtn.addActionListener(this);
        greenBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redBtn) {
            panel.setBackground(Color.red);
        } else if (e.getSource() == greenBtn) {
            panel.setBackground(Color.green);
        } else {
            panel.setBackground(Color.blue);
        }
    }
    public static void main(String[] args) {
        new ColorSelection();
    }
}
