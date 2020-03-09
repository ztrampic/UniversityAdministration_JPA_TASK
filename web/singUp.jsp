<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <link rel="stylesheet" type="text/css" href="./Css/singUp.css">
</head>
<body>
<div class="container">
    <label class="label">Registrate Page</label>
    <br>
    <p class="pass">${message}</p>
    <form class="wrapF" action="/singUp" method="post">
        <div class="wrapperLabelInputx2">
            <div class="wrapperLabelInput">
                <label class="label">Firstname</label>
                <input class="inputRound" required type="text" id="firstname" name="firstname"/>
            </div>
            <div class="wrapperLabelInput">
                <label class="label">Lastname</label>
                <input class="inputRound" required type="text" id="lastname" name="lastname"/>
            </div>
        </div>
        <div class="wrapperLabelInputx2">
            <div class="wrapperLabelInput">
                <label class="label">Username</label>
                <input class="inputRound" required type="text" id="username" name="username"/>
            </div>
            <div class="wrapperLabelInput">
                <label class="label">Index number</label>
                <input class="inputRound" required type="text" id="indexNumber" name="indexNumber"/>
            </div>
        </div>
        <div class="wrapperLabelInputx2">
            <div class="wrapperLabelInput">
                <label class="label">Password</label>
                <input class="inputRound" required type="password" id="password" name="password"/>
            </div>
            <div class="wrapperLabelInput">
                <label class="label">Confirm password</label>
                <input class="inputRound" required type="password" id="confirmPassword" name="confirmPassword"/>
            </div>
        </div>
        <div class="dateWrapper">
            <label class="label">Date of birth</label>
            <input class="inputRound" required type="date" id="dateOfBirth" name="dateOfBirth"/>
            <div>
                <button class="roundedButton" type="submit">Sing Up</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>
