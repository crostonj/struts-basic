<%--
  Created by IntelliJ IDEA.
  User: JeffCroston
  Date: 3/5/2025
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setAttribute("title", "Home Page");
    request.getRequestDispatcher("layout.jsp").forward(request, response);
%>
