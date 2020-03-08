package service.converter.impl;

import domain.Faculty;
import dto.FacultyDto;
import service.converter.FacultyConverter;

public class FacultyConverterImpl implements FacultyConverter {
    @Override
    public FacultyDto convertToDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId_faculty());
        facultyDto.setAddress(faculty.getAddress());
        facultyDto.setName(faculty.getName());
        return facultyDto;
    }
}
