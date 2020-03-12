package servlets;

import controller.ControllerFacade;
import domain.Faculty;
import dto.DepartmentDto;
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
import java.util.List;

@WebServlet(name = "ServletNewDepartment", urlPatterns = "/departments")
public class ServletNewDepartment extends HttpServlet {
    private final ViewResolver viewResolver;

    public ServletNewDepartment() {
        viewResolver = new ViewResolver();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String idDepartment = httpServletRequest.getParameter("idDepartment");
        if(idDepartment.equals("")){
            somethingWentWrong(httpServletRequest,httpServletResponse);
        }else{
            ControllerFacade.getInstance().getAdminController().deleteDepartment(Long.parseLong(idDepartment));
            List<DepartmentDto> list = (List<DepartmentDto>) httpServletRequest.getSession().getAttribute("departments");
            for (DepartmentDto departmentDto:list) {
                if(departmentDto.getId() == Long.parseLong(idDepartment)){
                    list.remove(departmentDto);
                    break;
                }
            }
            httpServletRequest.getSession().setAttribute("departments", list);
            httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDto departmentDto = createDtoDepartment(request,response);
        if(departmentDto == null){
           somethingWentWrong(request,response);
        }else {
            DepartmentDto newDepartment = ControllerFacade.getInstance().getAdminController().newDepartment(departmentDto);
            List<DepartmentDto> list = (List<DepartmentDto>) request.getSession().getAttribute("departments");
            list.add(newDepartment);
            request.getSession().setAttribute("departments", list);
            request.setAttribute("message", Messages.SUCCESS_ADD_DEPARTMENT.toString());
            request.getRequestDispatcher(request.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(request, response);
        }

    }

    private DepartmentDto createDtoDepartment(HttpServletRequest request, HttpServletResponse response) {
        DepartmentDto departmentDto = new DepartmentDto();
        FacultyDto facultyDto = new FacultyDto();
        if(request.getParameter("hiddenIdFaculty").equals("")){
            facultyDto.setId(null);
        }else {
            facultyDto.setId(Long.parseLong(request.getParameter("hiddenIdFaculty")));
        }
        departmentDto.setName(request.getParameter("name"));
        departmentDto.setFacultyDto(facultyDto);
        return departmentDto;
    }

    private void somethingWentWrong(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("message",Messages.SOMETHING_WRONG.toString());
        httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
    }
}
