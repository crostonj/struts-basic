<%--
  Created by IntelliJ IDEA.
  User: JeffCroston
  Date: 3/6/2025
  Time: 7:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%

    if (request.getAttribute("validAccess") == null || !(Boolean)request.getAttribute("validAccess")) {
        response.sendRedirect("home.jsp");
        return;
    }
%>

<div class="content">
    Contact us
</div>