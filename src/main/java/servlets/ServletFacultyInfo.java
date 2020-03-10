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
        FacultyDto facultyDto = createDto(request);
        if (facultyDto != null) {
            controllerFacade.newFaculty(facultyDto);
            String message = "Success!!!";
            request.setAttribute("message", message);
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin.jsp").forward(request, response);
        } else {
           somethingWentWrong(request,response);
        }
    }

    private FacultyDto createDto(HttpServletRequest request) {
        if(request.getParameter("name").equals("") || request.getParameter("address").equals("")){
            return null;
        }else {
            FacultyDto facultyDto = new FacultyDto();
            if(request.getParameter("hiddenId").equals("")){
                facultyDto.setId(null);
            }else{
                Long id = Long.parseLong(request.getParameter("hiddenId"));
                facultyDto.setId(id);
            }
            facultyDto.setName(request.getParameter("name"));
            facultyDto.setAddress( request.getParameter("address"));
            return facultyDto;
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
