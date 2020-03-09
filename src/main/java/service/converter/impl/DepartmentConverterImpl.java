package service.converter.impl;

import domain.Department;
import dto.DepartmentDto;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;

import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Set<DepartmentDto> convertToDtoSet(Set<Department> departmentSet) {
        Set<DepartmentDto> departmentDtos = departmentSet.stream().map(department -> {
            try{
                return convertToDto(department);
            }catch (Exception e){
                return null;
            }
        }).collect(Collectors.toSet());
        return departmentDtos;
    }
}
