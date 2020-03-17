package servlets;

import controller.facade.ControllerFacade;
import dto.*;
import enums.Messages;
import view.ViewConstants;
import view.ViewResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ServletProfessor", urlPatterns = "/professor")
public class ServletProfessor extends HttpServlet {
    private final ViewResolver viewResolver;
    private final HelperDto helperDto;

    public ServletProfessor() {
        viewResolver = new ViewResolver();
        helperDto = new HelperDto();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if(httpServletRequest.getParameter("idDepartment").equals("")){
            httpServletRequest.setAttribute("message", Messages.SOMETHING_WRONG.getMessage());
            httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
        }
        Long idDepartment = Long.parseLong(httpServletRequest.getParameter("idDepartment"));
        Set<ProfessorDtoResponse> professorDtoResponses = ControllerFacade.getInstance().getAdminController().getProfessorsForIdDepartment(idDepartment);
        httpServletRequest.setAttribute("message", Messages.SUCCESS_GET_ALL_PROFESSORS.getMessage());
        httpServletRequest.getSession().setAttribute("professors", professorDtoResponses);
        httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ProfessorDtoRequest professorDtoRequest = createProfessorDto(httpServletRequest);
        if(professorDtoRequest != null){
            try {
                ProfessorDtoRequest newDto = ControllerFacade.getInstance().getAuthController().registrateProfessor(professorDtoRequest);
                httpServletRequest.setAttribute("message", Messages.SUCCESS_ADD_PROFESSOR.getMessage());
                httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                httpServletRequest.setAttribute("message", e.getMessage());
                httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
            }
        }else {
            httpServletRequest.setAttribute("message", Messages.PASSWORDS_NOT_MATCH.getMessage());
            httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
        }
    }

    private ProfessorDtoRequest createProfessorDto(HttpServletRequest httpServletRequest) {
        if(httpServletRequest.getParameter("confirmPassword").equals(httpServletRequest.getParameter("password"))){
            ProfessorDtoRequest professorDtoRequest = new ProfessorDtoRequest();
            UserDetailsDto userDetailsDto = new UserDetailsDto();
            DepartmentDto departmentDto = new DepartmentDto();
            professorDtoRequest.setUserName(httpServletRequest.getParameter("userName"));
            professorDtoRequest.setPassword(httpServletRequest.getParameter("password"));
            userDetailsDto.setFirstName(httpServletRequest.getParameter("firstName"));
            userDetailsDto.setLastName(httpServletRequest.getParameter("lastName"));
            userDetailsDto.setTitle(helperDto.setProfessorTitle(httpServletRequest.getParameter("title")));
            userDetailsDto.setWorkingStarted(httpServletRequest.getParameter("dateOfEmployment"));
            departmentDto.setId(Long.parseLong(httpServletRequest.getParameter("departmentId")));
            userDetailsDto.setDepartmentDto(departmentDto);
            professorDtoRequest.setUserDetailsDto(userDetailsDto);
            return professorDtoRequest;
        }
        return null;
    }
}
