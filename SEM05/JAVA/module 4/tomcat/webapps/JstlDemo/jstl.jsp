<%-- Create a JSP application using JSTL tags for conditions, iteration and formatting, including c:if, c:forEach, c:choose, c:when and c:otherwise. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<c:set var="marks" value="75" />
<c:if test="${marks >= 40}">Pass<br></c:if>
<c:forEach var="i" begin="1" end="3">Item ${i}<br></c:forEach>
<c:choose><c:when test="${marks >= 60}">First</c:when><c:otherwise>Second</c:otherwise></c:choose>
</body></html>
