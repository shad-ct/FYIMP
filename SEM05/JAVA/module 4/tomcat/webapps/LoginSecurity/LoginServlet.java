// Develop a simple login application with protected resources where only authenticated users can access a particular Servlet or page.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        if (user.equals("admin") && pass.equals("1234")) {
            HttpSession s = req.getSession();
            s.setAttribute("user", user);
            res.sendRedirect("protected");
        } else {
            res.getWriter().println("Invalid login.");
        }
    }
}
