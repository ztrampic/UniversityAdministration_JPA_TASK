package dto;

import enums.Title;
import java.util.Set;

public class UserDetailsDto {
    private Title title;
    private String workingStarted;
    private DepartmentDto departmentDto;
    private Set<SubjectDto> subjectDtos;
    private Set<ExamDto> examDtos;
    private Long id;
    private String firstName;
    private String lastName;
    private String indexNumber;
    private String dateOfBirth;

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getWorkingStarted() {
        return workingStarted;
    }

    public void setWorkingStarted(String workingStarted) {
        this.workingStarted = workingStarted;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public Set<SubjectDto> getSubjectDtos() {
        return subjectDtos;
    }

    public void setSubjectDtos(Set<SubjectDto> subjectDtos) {
        this.subjectDtos = subjectDtos;
    }

    public Set<ExamDto> getExamDtos() {
        return examDtos;
    }

    public void setExamDtos(Set<ExamDto> examDtos) {
        this.examDtos = examDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
