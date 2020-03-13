package servlets;

import controller.facade.ControllerFacade;
import dto.StudentDtoRequest;
import dto.UserDetailsDto;
import enums.Messages;
import view.ViewConstants;
import view.ViewResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSingUp", urlPatterns = "/singUp")
public class ServletSingUp extends HttpServlet {
    private final ViewResolver viewResolver;

    public ServletSingUp() {
        viewResolver = new ViewResolver();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("password").equals(request.getParameter("confirmPassword"))){
            StudentDtoRequest studentDtoRequest = createStudentDto(request);
            try {
                ControllerFacade.getInstance().getAuthController().registrate(studentDtoRequest);
                request.setAttribute("message", Messages.SING_UP_SUCCESS.getMessage());
                request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.LOGIN)).forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.SING_UP)).forward(request, response);
            }
        }else {
            request.setAttribute("message", Messages.PASSWORDS_NOT_MATCH.getMessage());
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.SING_UP)).forward(request, response);
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
