// Develop an MVC-based application to add, view, update and delete student records using JSP, Servlet and JDBC.
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
public class MvcCrudApp extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root");
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), marks DOUBLE)");
            if (action.equals("add")) {
                st.executeUpdate("INSERT INTO students (name, marks) VALUES ('" + req.getParameter("name") + "', " + req.getParameter("marks") + ")");
            } else if (action.equals("delete")) {
                st.executeUpdate("DELETE FROM students WHERE id = " + req.getParameter("id"));
            } else if (action.equals("update")) {
                st.executeUpdate("UPDATE students SET marks = " + req.getParameter("marks") + " WHERE id = " + req.getParameter("id"));
            }
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            while (rs.next()) {
                HashMap<String, String> m = new HashMap<String, String>();
                m.put("id", String.valueOf(rs.getInt("id")));
                m.put("name", rs.getString("name"));
                m.put("marks", String.valueOf(rs.getDouble("marks")));
                list.add(m);
            }
            rs.close();
            st.close();
            con.close();
            req.setAttribute("list", list);
            RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
