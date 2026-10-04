<%-- Develop a JSP application using Expression Language (EL) to access JavaBean properties, request parameters and headers. --%>
<jsp:useBean id="s" class="beans.StudentBean" scope="request" />
<html><body>
Name: ${s.name}<br>
Marks: ${s.marks}<br>
Param: ${param.name}<br>
Header: ${header["user-agent"]}<br>
</body></html>
