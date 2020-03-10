package servlets;

import controller.ControllerFacade;
import domain.Faculty;
import dto.FacultyDto;
import dto.UserCredentials;
import dto.UserDtoResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUserLogin", urlPatterns = "/login")
public class ServletUserLogin extends HttpServlet {
    private final ControllerFacade controllerFacade;

    public ServletUserLogin() {
        controllerFacade = new ControllerFacade();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCredentials credentials = new UserCredentials(request.getParameter("username"), request.getParameter("password"));
        UserDtoResponse userDtoResponse = controllerFacade.authLogin(credentials);
        HttpSession session = request.getSession();
        if (userDtoResponse == null) {
            String message = "Bad Credentials!!!";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals("PROFESOR"))) {
            //String context = getServletContext().getContextPath();
            session.setAttribute("user", userDtoResponse);
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/professor.jsp").forward(request, response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals("ADMIN"))) {
            prepareAdminPage(request,response);
        } else if (userDtoResponse.getRoleNames().stream().anyMatch(role -> role.toString().equals("STUDENT"))) {
            session.setAttribute("user", userDtoResponse);
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/student.jsp").forward(request, response);
        }
    }

    private void prepareAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDto facultyDto = controllerFacade.getFacultyInfo();
        request.setAttribute("faculty", facultyDto);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null){
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        }
        request.getSession().removeAttribute("user");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
        request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
    }
}
