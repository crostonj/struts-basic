<%--
  Created by IntelliJ IDEA.
  User: JeffCroston
  Date: 3/6/2025
  Time: 6:41 AM
  To change this template use File | Settings | File Templates.
--%>

<div class="header">
    <div class="header-left">
        <h1>My JSP Site</h1>
        <nav>
            <div class="dropdown">
            <a href="layout.jsp">Home</a>
                <div class="dropdown-content">
                    <a href="#">Item One</a>
                    <a href="#">Item Two</a>
                    <a href="#">Item Three</a>
                    <a href="#">Item Four</a>
                    <a href="#">Item Five</a>
                </div>
            </div>
            <div class="dropdown">
                <a href="layout.jsp?page=about">About</a>
                <div class="dropdown-content">
                    <a href="#">Item One</a>
                    <a href="#">Item Two</a>
                    <a href="#">Item Three</a>
                    <a href="#">Item Four</a>
                    <a href="#">Item Five</a>
                </div>
            </div>
            <div class="dropdown">
                <a href="layout.jsp?page=contact">Contact</a>
                <div class="dropdown-content">
                    <a href="#">Item One</a>
                    <a href="#">Item Two</a>
                    <a href="#">Item Three</a>
                    <a href="#">Item Four</a>
                    <a href="#">Item Five</a>
                </div>
            </div>

        </nav>
    </div>
    <div class="header-right">
        <img src="images/profile.png" alt="Profile Picture" class="profile-pic">
    </div>
</div>