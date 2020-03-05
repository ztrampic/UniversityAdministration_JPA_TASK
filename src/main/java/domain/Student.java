package domain;

import org.hibernate.annotations.NaturalId;
import org.hibernate.criterion.Example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends UserDetails implements Serializable{
    @NaturalId
    private String indexNumber;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @ManyToOne(fetch = FetchType.LAZY)
    private StudyProgram studyProgram;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Exam> listOfPassedExams;

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public List<Exam> getListOfPassedExams() {
        return listOfPassedExams;
    }

    public void setListOfPassedExams(List<Exam> listOfPassedExams) {
        this.listOfPassedExams = listOfPassedExams;
    }

    /**
     * ------Methods for synchronization
     */
    public void addExam(Exam exam){
        exam.setStudent(this);
        if(exam.getPassed() == true){
            listOfPassedExams.add(exam);
        }else {
            this.setListOfPassedExams(listOfPassedExams);
        }
    }
    public void removeExam(Exam exam){
        listOfPassedExams.add(exam);
        exam.setStudent(null);
    }
}
