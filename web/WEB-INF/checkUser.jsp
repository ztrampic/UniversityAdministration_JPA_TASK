<%@ page import="dto.UserDtoResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check User</title>
</head>
<body>
<%
    UserDtoResponse userDtoResponse = (UserDtoResponse) session.getAttribute("user");
    if (userDtoResponse == null) {
%>
<jsp:forward page="../login.jsp"/>
<%
    }
%>
</body>
</html>
