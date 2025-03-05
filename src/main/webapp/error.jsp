<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            text-align: center;
            padding: 50px;
        }
        .error-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
            max-width: 500px;
        }
        h1 {
            color: #dc3545;
        }
        .error-details {
            margin-top: 15px;
            font-size: 14px;
            color: #333;
            background: #f1f1f1;
            padding: 10px;
            border-radius: 5px;
            word-break: break-word;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Oops! Something went wrong.</h1>
        <p>We apologize for the inconvenience. Please try again later.</p>

        <!-- Display detailed error message if available -->
        <s:if test="errorMessage != null">
            <div class="error-details">
                <strong>Error Details:</strong>
                <p><s:property value="errorMessage" /></p>
            </div>
        </s:if>

        <p><a href="<s:url action='home'/>">Go to Homepage</a></p>
    </div>
</body>
</html>
