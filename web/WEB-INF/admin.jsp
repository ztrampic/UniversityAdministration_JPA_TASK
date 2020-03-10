<%@ page import="dto.FacultyDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="../Css/admin.css">
</head>
<body>
<%
    FacultyDto facultyDto = (FacultyDto) request.getAttribute("faculty");
%>
<h1>${message}</h1>
<div class="parent">
    <div class="div1">
        <h1>Faculty Info</h1>
        <form action="/faculty" method="post">
            <div class="wrapper">
                <label>Name of faculty</label>
                <input type="text" name="name" value=<%=facultyDto == null ? "" : facultyDto.getName()%>>
            </div>
            <div class="wrapper">
                <label>Address</label>
                <input type="text" name="address" value=<%=facultyDto == null ? "" : facultyDto.getAddress()%>>
            </div>
            <input type="hidden" name="hiddenId" value=<%=facultyDto == null ? "" : facultyDto.getId()%>>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>
<%

%>
</body>
</html>
