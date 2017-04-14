<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>
<h3 style='color:red'><% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println(error);
    }
%></h3>
<form method="post" action="/register">
    <div align="center">
        Name: <input type="text" name="name"> <br><br>
        UserName: <input type="text" name="username"> <br><br>
        Password: <input type="password" name="password"> <br><br>
        <input type="submit" value="Register">
    </div>
</form>
<p>Already registered! <a href="/login">Login</a> here.</p>

</body>
</html>