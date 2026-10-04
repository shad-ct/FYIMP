// Develop a Java Applet that receives background color, foreground color, and a message through parameters specified in an HTML file. Retrieve these parameters in the init() method and display the customized message using paint(). Test the applet with at least three different sets of parameter values.
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class ColorParamApplet extends Applet {
    String message;
    Color bg;
    Color fg;
    Color parseColor(String c) {
        if (c == null) {
            return Color.white;
        }
        if (c.equalsIgnoreCase("red")) return Color.red;
        if (c.equalsIgnoreCase("blue")) return Color.blue;
        if (c.equalsIgnoreCase("green")) return Color.green;
        if (c.equalsIgnoreCase("yellow")) return Color.yellow;
        if (c.equalsIgnoreCase("black")) return Color.black;
        return Color.white;
    }
    public void init() {
        message = getParameter("message");
        bg = parseColor(getParameter("bgcolor"));
        fg = parseColor(getParameter("fgcolor"));
        setBackground(bg);
        setForeground(fg);
    }
    public void paint(Graphics g) {
        g.drawString(message, 30, 60);
    }
}
