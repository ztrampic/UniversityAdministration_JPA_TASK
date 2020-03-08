package dto;

import domain.Professor;

public class DepartmentDto {
    private Long id;
    private String name;
    private FacultyDto facultyDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyDto getFacultyDto() {
        return facultyDto;
    }

    public void setFacultyDto(FacultyDto facultyDto) {
        this.facultyDto = facultyDto;
    }
}
