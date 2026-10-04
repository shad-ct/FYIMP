// Develop a Java Applet that accepts a student's name, register number, course, and semester as parameters and displays the information in a formatted manner. Use the appropriate Applet life-cycle method to initialize the parameters and paint() to display them.
import java.applet.Applet;
import java.awt.Graphics;
public class StudentInfoApplet extends Applet {
    String name;
    String regNo;
    String course;
    String semester;
    public void init() {
        name = getParameter("name");
        regNo = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }
    public void paint(Graphics g) {
        g.drawString("Name: " + name, 20, 30);
        g.drawString("Register No: " + regNo, 20, 50);
        g.drawString("Course: " + course, 20, 70);
        g.drawString("Semester: " + semester, 20, 90);
    }
}
