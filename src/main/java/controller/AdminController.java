package controller;

import domain.Department;
import domain.Faculty;
import domain.Professor;
import dto.DepartmentDto;
import dto.FacultyDto;
import dto.ProfessorDtoRequest;
import dto.ProfessorDtoResponse;
import service.DepartmentService;
import service.FacultyService;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;
import service.converter.UserConverter;
import service.converter.impl.DepartmentConverterImpl;
import service.converter.impl.FacultyConverterImpl;
import service.converter.impl.UserConverterImpl;
import service.impl.DepartmentServiceImpl;
import service.impl.FacultyServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdminController {
    private final FacultyService facultyService;
    private final FacultyConverter facultyConverter;
    private final DepartmentService departmentService;
    private final DepartmentConverter departmentConverter;
    private final UserConverter userConverter;

    public AdminController() {
        facultyService = new FacultyServiceImpl();
        facultyConverter = new FacultyConverterImpl();
        departmentService = new DepartmentServiceImpl();
        departmentConverter = new DepartmentConverterImpl();
        userConverter = new UserConverterImpl();
    }

    public FacultyDto insertNewFaculty(FacultyDto facultyDto) {
        Faculty faculty = facultyConverter.convertToEntity(facultyDto);
        Faculty newFaculty = facultyService.saveOrUpdateFaculty(faculty);
        FacultyDto newDto = facultyConverter.convertToDto(newFaculty);
        return newDto;
    }

    public FacultyDto getFaculty() {
        Faculty faculty = facultyService.getFaculty();
        FacultyDto facultyDto = facultyConverter.convertToDto(faculty);
        return facultyDto;
    }

    public List<DepartmentDto> getDepartmens() {
        List<Department> departments = departmentService.getAllDepartmens();
        if(departments.size() == 0) return new ArrayList<>();
        List<DepartmentDto> departmentDtos = departmentConverter.convertToDtoList(departments);
        return departmentDtos;
    }

    public DepartmentDto newDepartment(DepartmentDto departmentDto) throws Exception {
        Faculty faculty = facultyService.getFaculty();
        Department department = departmentConverter.convertToEntity(departmentDto);
        department.setFaculty(faculty);
        Department newDepartment = departmentService.saveOrUpdate(department);
        faculty.addDepartment(newDepartment);
        facultyService.saveOrUpdateFaculty(faculty);
        DepartmentDto newDep = departmentConverter.convertToDto(newDepartment);
        return newDep;
    }

    public void deleteDepartment(long id) {
        Department foundDepartment = departmentService.findById(id);
        if(foundDepartment != null){
            departmentService.delete(foundDepartment);
        }
    }

    public Set<ProfessorDtoResponse> getProfessorsForIdDepartment(Long idDepartment) {
        Department department = departmentService.findById(idDepartment);
        Set<Professor> professors = department.getProfessorSet();
        Set<ProfessorDtoResponse> professorDtoResponse = userConverter.convertSetToSetProfessorDto(professors);
        return professorDtoResponse;
    }
}
