// Develop a Java Applet that displays a message such as Move the mouse inside the applet. When the user clicks at any position, display the x and y coordinates of the mouse pointer. Implement the required mouse-event handling methods and explain how the applet life cycle supports the execution of the program.
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MouseApplet extends Applet implements MouseListener {
    int x = -1;
    int y = -1;
    public void init() {
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        g.drawString("Move the mouse inside the applet", 20, 30);
        if (x != -1) {
            g.drawString("Clicked at: " + x + ", " + y, x, y);
        }
    }
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
