// Create a custom JSP tag that performs a reusable operation such as displaying student information, formatting text or generating a message, using a custom tag handler and TLD file.
package tags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
public class HelloTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello from custom tag. Student: Amit, Roll 1.");
    }
}
