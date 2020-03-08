package servlets;

import controller.ControllerFacade;
import dto.StudentDtoRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSingUp", urlPatterns = "/singUp")
public class ServletSingUp extends HttpServlet {
    private final ControllerFacade controllerFacade;

    public ServletSingUp() {
        controllerFacade = new ControllerFacade();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("password").equals(request.getParameter("confirmPassword"))){
            StudentDtoRequest studentDtoRequest = createStudentDto(request);
            controllerFacade.authRegistrate(studentDtoRequest);
        }else {
            String message  = "Passwords don`t match.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        }
    }

    private StudentDtoRequest createStudentDto(HttpServletRequest request) {
        StudentDtoRequest studentDtoRequest = new StudentDtoRequest();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dateOfBirth = request.getParameter("dateOfBirth");
        studentDtoRequest.setFirstName(firstname);
        studentDtoRequest.setLastName(lastname);
        studentDtoRequest.setDateOfBirth(dateOfBirth);
        studentDtoRequest.setPassword(password);
        studentDtoRequest.setUserName(username);
        return studentDtoRequest;
    }
}
