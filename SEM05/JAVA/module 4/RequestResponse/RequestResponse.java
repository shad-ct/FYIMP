// Create a Servlet that reads parameters from an HTML form and generates an appropriate HTML response using HttpServletRequest and HttpServletResponse.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class RequestResponse extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("Name: " + req.getParameter("name") + "<br>");
        out.println("Course: " + req.getParameter("course") + "<br>");
        out.println("</body></html>");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
}
