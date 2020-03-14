<%@ page import="dto.FacultyDto" %>
<%@ page import="dto.ProfessorDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="dto.DepartmentDto" %><%--
  Created by IntelliJ IDEA.
  User: Zare Raise Again
  Date: 3/13/2020
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin-addOn-professor</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../Css/admin.css">
</head>
<body>
    <%
        FacultyDto facultyDto = (FacultyDto) request.getSession().getAttribute("faculty");
        Set<DepartmentDto> departmentDtos = facultyDto.getDepartmentDtoSet();
    %>
<div class="parentAdminProfessor">
    <div class="divLeftProf">
        <form class="form-container" action="/professor" method="post">
            <div class="divLeftProf">
                <label>First name</label>
                <input required type="text" name="firstName" class="form-control">
                <label>Last name</label>
                <input required type="text" name="lastname" class="form-control">
                <label>Password</label>
                <input required type="text" name="password" class="form-control">
                <label>Title</label>
                <select required id="inputState" name="title" class="form-control">
                    <option selected value="PROFESSOR">Professor</option>
                    <option value="RESEARCHERS">Researcher</option>
                    <option value="DOCTOR">Doctor</option>
                </select>
                <label>Date of employment</label>
                <input required type="date" class="form-control">
            </div>
            <div class="divRightProf">
                <label>City</label>
                <input required type="text" class="form-control">
                <label>Username</label>
                <input required type="text" class="form-control">
                <label>Confirm password</label>
                <input required type="text" class="form-control">
                <label>Department</label>
                <select required class="form-control">
                  <%
                      for (DepartmentDto dep:departmentDtos) {
                  %>
                    <option id="<%=dep.getId()%>"><%=dep.getName()%></option>
                  <%
                      }
                  %>
                </select>
            </div>
            <div class="butt-div">
            <button type="submit" class="add-prof-btn">Submit</button>
            </div>
        </form>
    </div>
    <div class="divRightProf">

    </div>
</div>
</body>
</html>
