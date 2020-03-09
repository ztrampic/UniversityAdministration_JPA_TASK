package controller;

import domain.Faculty;
import dto.FacultyDto;
import service.FacultyService;
import service.converter.FacultyConverter;
import service.converter.impl.FacultyConverterImpl;
import service.impl.FacultyServiceImpl;

public class AdminController {
    private final FacultyService facultyService;
    private final FacultyConverter facultyConverter;

    public AdminController() {
        facultyService = new FacultyServiceImpl();
        facultyConverter = new FacultyConverterImpl();
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
}
