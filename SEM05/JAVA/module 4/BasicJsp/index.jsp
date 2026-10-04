<%-- Create a JSP page that displays dynamic student information and demonstrate the JSP translation, compilation and execution process. --%>
<%! int count = 0; %>
<html><body>
<% count++; %>
Name: Amit<br>Roll No: 1<br>
Visits: <%= count %><br>
Translation: JSP to Servlet. Compilation: Servlet to class. Execution: response sent.
</body></html>
