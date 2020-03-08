
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .badCredentials{
            color: red;
        }
    </style>
</head>
<br>
<br>
<form action="/login" method="post">
    <input type="text" id="username" name="username"/>
<br><br>
    <input type="password" id="password" name="password"/>
<br><br>
    <button type="submit">Login</button>
</form>
<p class="badCredentials">${message}</p>
</body>
</html>
