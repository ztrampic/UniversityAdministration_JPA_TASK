package domain;

import enums.Semester;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subject;
    private String name;
    private Integer eSPB;
    private Semester semester;
    @ManyToMany(mappedBy = "subjectSet")
    private Set<StudyProgram> studyProgramSet;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "subject_professor",
            joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_user_details")
    )
    private Set<Professor> professorSet = new HashSet<>();
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Exam> listOfExams;

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer geteSPB() {
        return eSPB;
    }

    public void seteSPB(Integer eSPB) {
        this.eSPB = eSPB;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Set<StudyProgram> getStudyProgramSet() {
        return studyProgramSet;
    }

    public void setStudyProgramSet(Set<StudyProgram> studyProgramSet) {
        this.studyProgramSet = studyProgramSet;
    }

    public Set<Professor> getProfessorSet() {
        return professorSet;
    }

    public void setProfessorSet(Set<Professor> professorSet) {
        this.professorSet = professorSet;
    }

    public List<Exam> getListOfExams() {
        return listOfExams;
    }

    public void setListOfExams(List<Exam> listOfExams) {
        this.listOfExams = listOfExams;
    }
}
