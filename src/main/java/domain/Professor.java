package domain;

import enums.Title;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Professor extends UserDetails{
    @NaturalId
    private Title title;
    @Temporal(TemporalType.DATE)
    private Date workingStarted;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @ManyToMany(mappedBy = "professorSet")
    private Set<Subject> subjectSet = new HashSet<>();
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL,orphanRemoval = true)
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
    /**
     *
     * -----Methods for synchronization---------
     */
    public void addSubject(Subject subject){
        subjectSet.add(subject);
        subject.getProfessorSet().add(this);
    }
    public void removeProfessor(Subject subject){
        subjectSet.remove(subject);
        subject.getProfessorSet().remove(this);
    }

    public void addExam(Exam exam){
        listOfExams.add(exam);
        exam.setProfessor(this);
    }
    public void removeExam(Exam exam){
        listOfExams.remove(exam);
        exam.setProfessor(null);
    }
}
