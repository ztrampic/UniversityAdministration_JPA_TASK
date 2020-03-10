package service.converter.impl;

import domain.Faculty;
import dto.FacultyDto;
import service.converter.DepartmentConverter;
import service.converter.FacultyConverter;

public class FacultyConverterImpl implements FacultyConverter {
    private final DepartmentConverter departmentConverter;
    public FacultyConverterImpl() {
        departmentConverter = new DepartmentConverterImpl();
    }
    @Override
    public FacultyDto convertToDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        if (faculty == null) return null;
        if (faculty.getDepartmentSet() == null){
            facultyDto.setDepartmentDtoSet(null);
        }else {
            facultyDto.setDepartmentDtoSet(departmentConverter.convertToDtoSet(faculty.getDepartmentSet()));
        }
        facultyDto.setId(faculty.getId_faculty());
        facultyDto.setAddress(faculty.getAddress());
        facultyDto.setName(faculty.getName());
        return facultyDto;
    }

    @Override
    public Faculty convertToEntity(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        faculty.setAddress(facultyDto.getAddress());
        if(facultyDto.getId() == null){
            faculty.setId_faculty(null);
        }else {
            faculty.setId_faculty(facultyDto.getId());
        }
        return faculty;
    }
}
