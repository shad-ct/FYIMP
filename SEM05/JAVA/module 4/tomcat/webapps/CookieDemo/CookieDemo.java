// Create a Servlet application that stores the user's name or preferences in a cookie and retrieves the information during subsequent requests.
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class CookieDemo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name != null) {
            res.addCookie(new Cookie("username", name));
            res.getWriter().println("Saved: " + name);
        } else {
            Cookie[] cookies = req.getCookies();
            String found = null;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        found = c.getValue();
                    }
                }
            }
            res.getWriter().println(found == null ? "No cookie. Use ?name=YourName" : "Hello " + found);
        }
    }
}
