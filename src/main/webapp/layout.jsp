<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Get the page parameter from the request
    String contentPage = request.getParameter("page");

    // Default page if no parameter is passed
    if (contentPage == null || contentPage.isEmpty()) {
        contentPage = "index";  // Set default page
    }

    contentPage = contentPage + ".jsp";  // Append .jsp to the page name

    request.setAttribute("validAccess", true);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("title") != null ? request.getAttribute("title") : "JSP Site" %></title>
    <link rel="stylesheet" type="text/css" href="css/layout.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="body-content">
    <jsp:include page="<%= contentPage %>" />
</div>

<%@ include file="footer.jsp" %>

</body>
</html>

