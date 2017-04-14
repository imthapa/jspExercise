<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h2>Welcome <%= session.getAttribute("username")%></h2>

<h3>LogoutServlet <a href="/logout">here!</a> </h3>

</body>
</html>