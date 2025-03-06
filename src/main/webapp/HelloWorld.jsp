<%
  String referer = request.getHeader("Referer");
  if (referer == null || !referer.contains("layout.jsp")) {
    response.sendRedirect("home.jsp");
    return;
  }
%>


<h2><s:property value="messageStore.getMessage()" /></h2>
