// Develop a Java Applet that displays messages indicating when the init(), start(), paint(), stop(), and destroy() methods are executed. Run the applet and observe the order in which these methods are invoked. Write a brief observation explaining the role of each method.
import java.applet.Applet;
import java.awt.Graphics;
public class AppletLifeCycle extends Applet {
    String message = "";
    public void init() {
        message = message + "init() called. ";
        System.out.println("init() called.");
    }
    public void start() {
        message = message + "start() called. ";
        System.out.println("start() called.");
    }
    public void paint(Graphics g) {
        g.drawString(message + "paint() called.", 20, 50);
        System.out.println("paint() called.");
    }
    public void stop() {
        System.out.println("stop() called.");
    }
    public void destroy() {
        System.out.println("destroy() called.");
    }
}
