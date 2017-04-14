<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex1</title>
</head>
<body>
<h1>Question</h1>
<h2>Write a JSP to output the entire line, “Hello!  The time is now …”
    but use a scriptlet for the complete string, including the HTML tags.
</h2>

<% out.println("Hello!  The time is now "+ new Date());%>
</body>
</html>
