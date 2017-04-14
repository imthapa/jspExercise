<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h3 style='color:red'><% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println(error);
    }
%></h3>
<h3 style='color:green'><% String success = (String) request.getAttribute("success");
    if (success != null) {
        out.println(success);
    }
%></h3>

<form method="post" action="/login">
    <div align="center">
        UserName: <input type="text" name="username"> <br><br>
        Password: <input type="password" name="password"> <br><br>
        <input type="submit" value="Login">
    </div>
</form>
<p>Not register yet! <a href="/register">Register</a> here.</p>

</body>
</html>