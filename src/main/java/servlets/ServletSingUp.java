package servlets;

import controller.ControllerFacade;
import dto.StudentDtoRequest;
import dto.UserDetailsDto;

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
            String message  = "Success you can now login.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        }else {
            String message  = "Passwords don`t match.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "/singUp.jsp").forward(request, response);
        }
    }

    private StudentDtoRequest createStudentDto(HttpServletRequest request) {
        StudentDtoRequest studentDtoRequest = new StudentDtoRequest();
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String indexNumber = request.getParameter("indexNumber");
        studentDtoRequest.setPassword(password);
        studentDtoRequest.setUserName(username);
        userDetailsDto.setDateOfBirth(dateOfBirth);
        userDetailsDto.setLastName(lastname);
        userDetailsDto.setFirstName(firstname);
        userDetailsDto.setIndexNumber(indexNumber);
        studentDtoRequest.setUserDetailsDto(userDetailsDto);
        return studentDtoRequest;
    }
}
