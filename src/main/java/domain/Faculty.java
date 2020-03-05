package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Faculty.getAll",query = "SELECT f FROM Faculty f")
})
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_faculty;
    private String name;
    private String address;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Department> departmentSet;

    public Long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(Long id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Department> getDepartmentSet() {
        return departmentSet;
    }

    public void setDepartmentSet(Set<Department> departmentSet) {
        this.departmentSet = departmentSet;
    }

    /**
     * -----Methods for synchronization---------
     */
    public void addDepartment(Department department) {
        departmentSet.add(department);
        department.setFaculty(this);
    }

    public void removeDepartment(Department department) {
        departmentSet.remove(department);
        department.setFaculty(null);
    }
}
