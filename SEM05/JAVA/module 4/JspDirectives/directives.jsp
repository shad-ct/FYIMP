<%-- Create JSP pages demonstrating important page directive attributes such as import, contentType and errorPage. --%>
<%@ page import="java.util.Date" contentType="text/html" errorPage="error.jsp" %>
<html><body>
Date: <%= new Date() %><br>
ContentType: text/html<br>
<% int x = 10 / 2; %>Result: <%= x %>
</body></html>
