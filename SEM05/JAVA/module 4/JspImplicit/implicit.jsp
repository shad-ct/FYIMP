<%-- Develop a JSP page demonstrating commonly used implicit objects such as request, response, session, application, out, config, pageContext and exception. --%>
<html><body>
Method: <%= request.getMethod() %><br>
Session: <%= session.getId() %><br>
App: <%= application.getServerInfo() %><br>
<% out.println("Hello from out"); %><br>
Config: <%= config.getServletName() %><br>
Context: <%= pageContext.getRequest() != null %><br>
</body></html>
