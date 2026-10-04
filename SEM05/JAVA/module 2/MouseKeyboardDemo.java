// Develop an AWT application that displays the current mouse position inside a Frame. The application should respond to mouse clicks, mouse movement, and keyboard events. Use appropriate event listener interfaces and demonstrate the use of adapter classes to avoid implementing unnecessary listener methods.
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MouseKeyboardDemo extends Frame {
    Label label;
    MouseKeyboardDemo() {
        setTitle("Mouse and Keyboard Demo");
        setSize(400, 300);
        label = new Label("Move mouse or press key");
        add(label);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Clicked: " + e.getX() + ", " + e.getY());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                label.setText("Position: " + e.getX() + ", " + e.getY());
            }
        });
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                label.setText("Key: " + e.getKeyChar());
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new MouseKeyboardDemo();
    }
}
