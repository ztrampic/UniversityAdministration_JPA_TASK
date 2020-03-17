package dto;

import java.util.Set;

public class ProfessorDtoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String dateOfEmployment;
    private DepartmentDto departmentDto;
    private Set<SubjectDto> subjectDtoSet;
    private Set<ExamDto> examDtoSet;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public Set<SubjectDto> getSubjectDtoSet() {
        return subjectDtoSet;
    }

    public void setSubjectDtoSet(Set<SubjectDto> subjectDtoSet) {
        this.subjectDtoSet = subjectDtoSet;
    }

    public Set<ExamDto> getExamDtoSet() {
        return examDtoSet;
    }

    public void setExamDtoSet(Set<ExamDto> examDtoSet) {
        this.examDtoSet = examDtoSet;
    }
}
