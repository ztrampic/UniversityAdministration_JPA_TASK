package servlets;

import controller.ControllerFacade;
import domain.Faculty;
import dto.FacultyDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletFacultyInfo" ,urlPatterns = "/faculty")
public class ServletFacultyInfo extends HttpServlet {
    private final ControllerFacade controllerFacade;

    public ServletFacultyInfo() {
        controllerFacade = new ControllerFacade();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDto facultyDto = (FacultyDto) request.getAttribute("facultyDto");
        if (facultyDto != null) {
            controllerFacade.newFaculty(facultyDto);
            String message = "Success!!!";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "/admin.jsp").forward(request, response);
        } else {
           somethingWentWrong(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDto facultyDto = controllerFacade.getFacultyInfo();
        if (facultyDto != null) {
            request.setAttribute("faculty", facultyDto);
            request.getRequestDispatcher(request.getContextPath() + "/admin.jsp").forward(request, response);
        }else {
            somethingWentWrong(request,response);
        }
    }

    private void somethingWentWrong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Something went wrong!!!";
        request.setAttribute("message", message);
        request.getRequestDispatcher(request.getContextPath() + "/admin.jsp").forward(request, response);
    }
}
