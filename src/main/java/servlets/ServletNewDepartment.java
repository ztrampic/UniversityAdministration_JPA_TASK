package servlets;

import controller.facade.ControllerFacade;
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
import java.util.Set;

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
            FacultyDto facultyDto = (FacultyDto) httpServletRequest.getSession().getAttribute("faculty");
            Set<DepartmentDto> departmentDtoSet = facultyDto.getDepartmentDtoSet();
            for (DepartmentDto departmentDto:departmentDtoSet) {
                if(departmentDto.getId() == Long.parseLong(idDepartment)){
                    departmentDtoSet.remove(departmentDto);
                    break;
                }
            }
            httpServletRequest.getSession().setAttribute("faculty", facultyDto);
            httpServletRequest.getSession().setAttribute("message",Messages.SUCCESS_REMOVE_DEPARTMENT.getMessage());
            httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDto departmentDto = createDtoDepartment(request,response);
        if(departmentDto == null){
           somethingWentWrong(request,response);
        }else {
            try {
                DepartmentDto newDepartment = ControllerFacade.getInstance().getAdminController().newDepartment(departmentDto);
                FacultyDto facultyDto= (FacultyDto) request.getSession().getAttribute("faculty");
                facultyDto.getDepartmentDtoSet().add(newDepartment);
                request.getSession().setAttribute("faculty", facultyDto);
                request.setAttribute("message", Messages.SUCCESS_ADD_DEPARTMENT.getMessage());
            }catch (Exception e){
                request.setAttribute("message", e.getMessage());
            }
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
        if(request.getParameter("name").equals("")) return null;
        departmentDto.setName(request.getParameter("name"));
        departmentDto.setFacultyDto(facultyDto);
        return departmentDto;
    }

    private void somethingWentWrong(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("message",Messages.SOMETHING_WRONG.getMessage());
        httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath() + viewResolver.getPage(ViewConstants.ADMIN)).forward(httpServletRequest, httpServletResponse);
    }
}
