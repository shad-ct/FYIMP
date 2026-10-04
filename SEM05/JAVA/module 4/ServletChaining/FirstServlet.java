// Create two Servlets where the first Servlet processes a request and forwards or includes the request to the second Servlet using RequestDispatcher.
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("msg", "Hello from FirstServlet");
        RequestDispatcher rd = req.getRequestDispatcher("second");
        rd.forward(req, res);
    }
}
