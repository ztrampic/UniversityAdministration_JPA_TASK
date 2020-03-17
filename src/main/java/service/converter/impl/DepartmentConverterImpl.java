package service.converter.impl;

import domain.Department;
import domain.Faculty;
import dto.DepartmentDto;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentConverterImpl implements DepartmentConverter {
//    private final FacultyConverter facultyConverter;
//
//    public DepartmentConverterImpl() {
//        facultyConverter = new FacultyConverterImpl();
//    }

    @Override
    public DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        if(department == null) return null;
        departmentDto.setId(department.getId_department());
        departmentDto.setName(department.getName());
//        departmentDto.setFacultyDto(facultyConverter.convertToDto(department.getFaculty()));
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

    @Override
    public List<DepartmentDto> convertToDtoList(List<Department> departments) {
        List<DepartmentDto> departmentDtos = departments.stream().map(department -> {
            try{
                return convertToDto(department);
            }catch (Exception e){
                return null;
            }
        }).collect(Collectors.toList());
        return departmentDtos;
    }

    @Override
    public Department convertToEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        if(departmentDto.getId() == null) {
            department.setId_department(null);
        }else {
            department.setId_department(departmentDto.getId());
        }
        department.setName(departmentDto.getName());
        return department;
    }
}
