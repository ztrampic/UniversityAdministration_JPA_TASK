package domain;

import enums.Title;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Professor.getAll",query = "SELECT p FROM Professor p")
})
public class Professor extends UserDetails implements Serializable {
    @Enumerated(value = EnumType.STRING)
    private Title title;
    @Temporal(TemporalType.DATE)
    private Date workingStarted;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @ManyToMany(mappedBy = "professorSet")
    private Set<Subject> subjectSet = new HashSet<>();
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> listOfExams;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Date getWorkingStarted() {
        return workingStarted;
    }

    public void setWorkingStarted(Date workingStarted) {
        this.workingStarted = workingStarted;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public List<Exam> getListOfExams() {
        return listOfExams;
    }

    public void setListOfExams(List<Exam> listOfExams) {
        this.listOfExams = listOfExams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return getTitle() == professor.getTitle() &&
                Objects.equals(getWorkingStarted(), professor.getWorkingStarted()) &&
                Objects.equals(getDepartment(), professor.getDepartment()) &&
                Objects.equals(getSubjectSet(), professor.getSubjectSet()) &&
                Objects.equals(getListOfExams(), professor.getListOfExams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getWorkingStarted(), getDepartment(), getSubjectSet(), getListOfExams());
    }

    /**
     * -----Methods for synchronization---------
     */
    public void addSubject(Subject subject) {
        subjectSet.add(subject);
        subject.getProfessorSet().add(this);
    }

    public void removeProfessor(Subject subject) {
        subjectSet.remove(subject);
        subject.getProfessorSet().remove(this);
    }

    public void addExam(Exam exam) {
        listOfExams.add(exam);
        exam.setProfessor(this);
    }

    public void removeExam(Exam exam) {
        listOfExams.remove(exam);
        exam.setProfessor(null);
    }

}
