package servlets;

import controller.ControllerFacade;
import dto.DepartmentDto;
import dto.FacultyDto;
import dto.UserCredentials;
import dto.UserDtoResponse;
import enums.Messages;
import enums.RoleName;
import view.ViewConstants;
import view.ViewResolver;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUserLogin", urlPatterns = "/login")
public class ServletUserLogin extends HttpServlet {
    private final ViewResolver viewResolver;

    public ServletUserLogin() {
        viewResolver = new ViewResolver();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCredentials credentials = new UserCredentials(request.getParameter("username"), request.getParameter("password"));
        UserDtoResponse userDtoResponse = ControllerFacade.getInstance().getAuthController().login(credentials);
        if (userDtoResponse == null) {
            request.setAttribute("message", Messages.BAD_CREDENTIALS.toString());
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.LOGIN)).forward(request, response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals(RoleName.PROFESOR.toString()))) {
            request.getSession().setAttribute("user", userDtoResponse);
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.PROFESSOR)).forward(request, response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals(RoleName.ADMIN.toString()))) {
            request.getSession().setAttribute("user", userDtoResponse);
            prepareAdminPage(request, response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals(RoleName.STUDENT.toString()))) {
            request.getSession().setAttribute("user", userDtoResponse);
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.STUDENT)).forward(request, response);
        }
    }

    private void prepareAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDto facultyDto = ControllerFacade.getInstance().getAdminController().getFaculty();
        List<DepartmentDto> departmentDtos = ControllerFacade.getInstance().getAdminController().getDepartmens();
        request.getSession().setAttribute("departments", departmentDtos);
        request.getSession().setAttribute("faculty", facultyDto);
        request.getRequestDispatcher(request.getContextPath() +  viewResolver.getPage(ViewConstants.ADMIN)).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.LOGIN)).forward(request, response);
        }
        request.getSession().removeAttribute("user");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.LOGIN)).forward(request, response);
    }
}
