<%-- Create a JSP application demonstrating standard JSP actions such as jsp:include, jsp:forward, jsp:useBean, jsp:setProperty and jsp:getProperty. --%>
<jsp:useBean id="s" class="beans.StudentBean" scope="request" />
<jsp:setProperty name="s" property="name" value="Ravi" />
<html><body>
<jsp:include page="header.jsp" />
Name: <jsp:getProperty name="s" property="name" /><br>
Roll: <jsp:getProperty name="s" property="rollNo" /><br>
</body></html>
