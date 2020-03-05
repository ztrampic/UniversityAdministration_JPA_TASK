package domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_department;
    @NotNull
    @Column(unique=true)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Professor> professorSet = new HashSet<>();

    public Long getId_department() {
        return id_department;
    }

    public void setId_department(Long id_department) {
        this.id_department = id_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Professor> getProfessorSet() {
        return professorSet;
    }

    public void setProfessorSet(Set<Professor> professorSet) {
        this.professorSet = professorSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return id_department.equals(that.id_department);
    }

    @Override
    public int hashCode() {
        return id_department.hashCode();
    }

    /**
     *
     * -----Methods for synchronization---------
     */
    public void addProfessor(Professor professor){
        professorSet.add(professor);
        professor.setDepartment(this);
    }
    public void removeProfessor(Professor professor){
        professorSet.remove(professor);
        professor.setDepartment(null);
    }
}
