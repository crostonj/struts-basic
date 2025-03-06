<%--
  Created by IntelliJ IDEA.
  User: JeffCroston
  Date: 3/6/2025
  Time: 6:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%

    if (request.getAttribute("validAccess") == null || !(Boolean)request.getAttribute("validAccess")) {
        response.sendRedirect("home.jsp");
        return;
    }
%>


<div class="header">
    <h1>My JSP Site</h1>
    <nav>
        <a href="home.jsp">Home</a> |
        <a href="home.jsp?page=about">About</a> |
        <a href="home.jsp?page=contact">Contact</a>
    </nav>
</div>
