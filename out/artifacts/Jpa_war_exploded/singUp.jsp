<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wrapF{
            width: inherit;
        }
        .wrapD{
            display: flex;
            width: 40%;
        }
    </style>
</head>
<body>
<h3>Sing Up Page</h3>
<br>
<div class="wrapD">
    <form class="wrapF">
        <label>Firstname</label>
        <input required type="text" id="firstname" name="firstname"/>
        <br><br>
        <label>Lastname</label>
        <input required type="text" id="lastname" name="lastname"/>
        <br><br>
        <label>Username</label>
        <input required type="text" id="username" name="username"/>
        <br><br>
        <label>Password</label>
        <input required type="password" id="password" name="password"/>
        <br><br>
        <label>Confirm password</label>
        <input required type="password" id="confirmPassword" name="confirmPassword"/>
        <br><br>
        <label>Date of birth</label>
        <input required type="date" id="dateOfBirth"/>
        <br><br>
        <button type="submit">Sing Up</button>
    </form>
</div>
</body>
</html>
