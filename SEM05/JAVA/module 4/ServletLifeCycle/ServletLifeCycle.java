// Create a Servlet demonstrating the init(), service() and destroy() life-cycle methods and display messages showing when each method is executed.
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class ServletLifeCycle extends HttpServlet {
    public void init() throws ServletException {
        System.out.println("init() called.");
    }
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() called.");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("service() executed. Check console for init/service/destroy.");
    }
    public void destroy() {
        System.out.println("destroy() called.");
    }
}
