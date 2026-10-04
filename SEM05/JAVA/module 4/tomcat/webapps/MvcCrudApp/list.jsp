<%-- Develop an MVC-based application to add, view, update and delete student records using JSP, Servlet and JDBC. --%>
<%@ page import="java.util.*" %>
<html><body>
<h2>Students</h2>
<% ArrayList<HashMap<String,String>> list = (ArrayList<HashMap<String,String>>) request.getAttribute("list"); %>
<% if (list != null) { for (HashMap<String,String> m : list) { %>
<%= m.get("id") %> <%= m.get("name") %> <%= m.get("marks") %><br>
<% } } %>
</body></html>
