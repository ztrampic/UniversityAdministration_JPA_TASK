
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./Css/login.css">
</head>

<div class="container">
    <a href="/singUp.jsp" class = "inputRound">SingUp Form</a>
    <br><br>
    <p class="badCredentials">${message}</p>
    <br>
    <br>
<form action="/login" method="post">
    <label class="label">Username</label>
    <br>
    <input class="inputRound" type="text" id="username" name="username"/>
<br><br>
    <label class="label">Password</label>
    <br>
    <input class="inputRound" type="password" id="password" name="password"/>
<br><br>
    <button class="roundedButton" type="submit">Login</button>
</form>
</div>
</body>
</html>
