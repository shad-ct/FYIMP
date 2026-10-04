// Develop a Java Applet that displays a circle moving horizontally across the applet window. Use appropriate life-cycle methods to initialize the animation, start it, temporarily stop it, and resume it. Demonstrate the effect of the start() and stop() methods on the animation.
import java.applet.Applet;
import java.awt.Graphics;
public class AnimationApplet extends Applet implements Runnable {
    int x = 0;
    Thread t;
    boolean running = false;
    public void init() {
        x = 0;
    }
    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }
    public void run() {
        while (running) {
            x = x + 5;
            if (x > getWidth()) {
                x = 0;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
        }
    }
    public void stop() {
        running = false;
    }
    public void paint(Graphics g) {
        g.fillOval(x, 50, 30, 30);
    }
}
