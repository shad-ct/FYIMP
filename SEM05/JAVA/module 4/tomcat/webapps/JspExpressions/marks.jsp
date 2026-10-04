<%-- Create a JSP page that uses declarations and expressions to calculate and display student marks, total and average. --%>
<%! int total(int a, int b, int c) { return a + b + c; } %>
<html><body>
<% int a = 80; int b = 75; int c = 90; int t = total(a, b, c); double avg = t / 3.0; %>
Mark1: <%= a %><br>Mark2: <%= b %><br>Mark3: <%= c %><br>
Total: <%= t %><br>Average: <%= avg %><br>
</body></html>
