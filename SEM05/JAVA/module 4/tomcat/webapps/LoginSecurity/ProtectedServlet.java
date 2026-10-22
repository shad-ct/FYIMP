// Develop a simple login application with protected resources where only authenticated users can access a particular Servlet or page.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class ProtectedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s != null && s.getAttribute("user") != null) {
            res.getWriter().println("Welcome " + s.getAttribute("user") + ", secret page.");
        } else {
            res.getWriter().println("Access denied. Please login.");
        }
    }
}
