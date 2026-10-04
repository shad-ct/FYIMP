// Develop a simple shopping cart/session-based application using HttpSession to maintain user information across multiple requests.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
public class SessionCart extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(true);
        ArrayList<String> cart = (ArrayList<String>) s.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<String>();
            s.setAttribute("cart", cart);
        }
        String item = req.getParameter("item");
        if (item != null) {
            cart.add(item);
        }
        res.getWriter().println("Cart: " + cart.toString());
    }
}
