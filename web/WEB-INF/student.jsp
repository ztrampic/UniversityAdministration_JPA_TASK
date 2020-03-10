<%@ page import="dto.UserDtoResponse" %>
<%@ page import="dto.ExamDto" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Student panel</title>
    <link rel="stylesheet" type="text/css" href="../Css/student.css">
</head>
<body>
<%
    UserDtoResponse user = (UserDtoResponse) session.getAttribute("user");
    Set<ExamDto> examDtos = user.getUserDetailsDto().getExamDtos();
    if(examDtos == null){
        examDtos = new HashSet<>();
    }
%>
<div class="userInfo">
    <label class="label"><span class="span">Username:</span> <%=user.getUserName()%>
    </label>
    <label class="label"><span class="span">Date of birth:</span> <%=user.getUserDetailsDto().getDateOfBirth()%>
    </label>
    <label class="label"><span class="span">Firstname:</span> <%=user.getUserDetailsDto().getFirstName()%>
    </label>
    <label class="label"><span class="span">Lastname:</span> <%=user.getUserDetailsDto().getLastName()%>
    </label>
    <label class="label"><span class="span">IndexNumber:</span> <%=user.getUserDetailsDto().getIndexNumber()%>
    </label>
</div>
<h1>STUDENT PAGE</h1>
<div class="tableExams">

</div>
<form action="/login" method="get">
    <input type="submit" value="Logout">
</form>
</body>
</html>
