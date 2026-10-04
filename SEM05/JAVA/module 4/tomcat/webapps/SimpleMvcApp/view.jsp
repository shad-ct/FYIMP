<%-- Develop a simple Student Management application following Model-View-Controller architecture. --%>
<%@ page import="mvc.Student" %>
<html><body>
<% Student s = (Student) request.getAttribute("student"); %>
Name: <%= s.getName() %><br>
Roll No: <%= s.getRollNo() %><br>
Marks: <%= s.getMarks() %><br>
</body></html>
