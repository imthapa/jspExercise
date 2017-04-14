
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex2</title>
</head>
<body>
<h1>Question</h1>
<h2>Accept the value of n and print numbers from 1 to n.</h2>
<% try {
    int n = Integer.parseInt(request.getParameter("n"));
    for (int i = 1; i <= n; i++) {
        out.println(i);
    }
} catch (NumberFormatException e) {
    out.println("Please enter a query parameter n of type Integer in format ?n=integer in url");
    e.printStackTrace();
}
%>
</body>
</html>
