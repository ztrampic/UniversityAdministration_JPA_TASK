package servlets;

import controller.ControllerFacade;
import domain.Faculty;
import dto.FacultyDto;
import enums.Messages;
import view.ViewConstants;
import view.ViewResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletFacultyInfo" ,urlPatterns = "/faculty")
public class ServletFacultyInfo extends HttpServlet {
    private final ViewResolver viewResolver;

    public ServletFacultyInfo() {
        viewResolver = new ViewResolver();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDto facultyDto = createDto(request);
        if (facultyDto != null) {
            ControllerFacade.getInstance().getAdminController().insertNewFaculty(facultyDto);
            request.setAttribute("message", Messages.SUCCESS_FACULTY_INSERT.toString());
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(request, response);
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
        FacultyDto facultyDto = ControllerFacade.getInstance().getAdminController().getFaculty();
        if (facultyDto != null) {
            request.setAttribute("faculty", facultyDto);
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(request, response);
        }else {
            somethingWentWrong(request,response);
        }
    }

    private void somethingWentWrong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", Messages.SOMETHING_WRONG.toString());
        request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(request, response);
    }
}
