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

<div class="content">
    <h2>About Us</h2>
    <p>We are a company dedicated to providing the best services.</p>
</div>

