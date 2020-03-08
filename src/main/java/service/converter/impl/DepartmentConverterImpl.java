package service.converter.impl;

import domain.Department;
import dto.DepartmentDto;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;

public class DepartmentConverterImpl implements DepartmentConverter {
    private final FacultyConverter facultyConverter;

    public DepartmentConverterImpl() {
        facultyConverter = new FacultyConverterImpl();
    }

    @Override
    public DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        if(department == null) return null;
        departmentDto.setId(department.getId_department());
        departmentDto.setName(department.getName());
        departmentDto.setFacultyDto(facultyConverter.convertToDto(department.getFaculty()));
        return departmentDto;
    }
}
