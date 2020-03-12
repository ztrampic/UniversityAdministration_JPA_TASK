package controller;

import domain.Department;
import domain.Faculty;
import dto.DepartmentDto;
import dto.FacultyDto;
import service.DepartmentService;
import service.FacultyService;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;
import service.converter.impl.DepartmentConverterImpl;
import service.converter.impl.FacultyConverterImpl;
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

    public AdminController() {
        facultyService = new FacultyServiceImpl();
        facultyConverter = new FacultyConverterImpl();
        departmentService = new DepartmentServiceImpl();
        departmentConverter = new DepartmentConverterImpl();
    }

    public void insertNewFaculty(FacultyDto facultyDto) {
        Faculty faculty = facultyConverter.convertToEntity(facultyDto);
        Faculty newFaculty = facultyService.saveOrUpdateFaculty(faculty);
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

    public DepartmentDto newDepartment(DepartmentDto departmentDto) {
        Faculty faculty = facultyService.getFaculty();
        Department department = departmentConverter.convertToEntity(departmentDto);
        Department newDepartment = departmentService.saveOrUpdate(department);
        faculty.addDepartment(newDepartment);
        facultyService.saveOrUpdateFaculty(faculty);
        DepartmentDto newDep = departmentConverter.convertToDto(newDepartment);
        return newDep;
    }

    public void deleteDepartment(long id) {
        Department foundDepartment = departmentService.findById(id);
        if(foundDepartment != null){
            foundDepartment.setFaculty(null);
            departmentService.delete(foundDepartment);
        }
    }
}
