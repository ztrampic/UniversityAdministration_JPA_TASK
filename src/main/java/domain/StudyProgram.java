package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class StudyProgram implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_program;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "program_subject",
            joinColumns = @JoinColumn(name = "id_program"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private Set<Subject> subjectSet = new HashSet<>();
    @OneToMany(mappedBy = "studyProgram", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Student> studentSet = new HashSet<>();

    public Long getId_program() {
        return id_program;
    }

    public void setId_program(Long id_program) {
        this.id_program = id_program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    /**
     * --------Methods for synchronization-------------
     */

    public void addSubject(Subject subject){
        subjectSet.add(subject);
        subject.getStudyProgramSet().add(this);
    }
    public void removeSubject(Subject subject){
        subjectSet.remove(subject);
        subject.getStudyProgramSet().remove(this);
    }

    public void addStudent(Student student){
        studentSet.add(student);
        student.setStudyProgram(this);
    }

    public void removeStudent(Student student){
        studentSet.remove(student);
        student.setStudyProgram(null);
    }



}
