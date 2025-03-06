<%
    if (request.getAttribute("validAccess") == null || !(Boolean)request.getAttribute("validAccess")) {
        response.sendRedirect("home.jsp");
        return;
    }
%>

<div class="content">
<h2>Welcome, ${sessionScope.user}!</h2>


<% if (session.getAttribute("user") == null) { %>
<a href="login.action">
    <button>Login</button>
</a>
<% } else { %>
<form action="logout.action">
    <input type="submit" value="Logout">
</form>
<% } %>
</div>