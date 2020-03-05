package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@NamedQueries({
        @NamedQuery(name = "Exam.getAll",query = "SELECT e FROM Exam e")
})
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_exam;
    @Temporal(TemporalType.DATE)
    private Date timeOfExam;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;
    private Boolean isPassed;
    private Integer grade;

    public Long getId_exam() {
        return id_exam;
    }

    public void setId_exam(Long id_exam) {
        this.id_exam = id_exam;
    }

    public Date getTimeOfExam() {
        return timeOfExam;
    }

    public void setTimeOfExam(Date timeOfExam) {
        this.timeOfExam = timeOfExam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Boolean getPassed() {
        return isPassed;
    }

    public void setPassed(Boolean passed) {
        isPassed = passed;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        return id_exam.equals(exam.id_exam);
    }

    @Override
    public int hashCode() {
        return id_exam.hashCode();
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id_exam=" + id_exam +
                ", timeOfExam=" + timeOfExam +
                ", student=" + student +
                ", professor=" + professor +
                ", subject=" + subject +
                ", isPassed=" + isPassed +
                ", grade=" + grade +
                '}';
    }
}
