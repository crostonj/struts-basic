<%--
  Created by IntelliJ IDEA.
  User: JeffCroston
  Date: 3/6/2025
  Time: 6:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%

    if (request.getAttribute("validAccess") == null || !(Boolean)request.getAttribute("validAccess")) {
        response.sendRedirect("home.jsp");
        return;
    }
%>


<div class="footer">
    &copy; 2025 My JSP Website | All Rights Reserved
</div>
