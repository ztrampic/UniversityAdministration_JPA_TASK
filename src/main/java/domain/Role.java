package domain;

import enums.RoleName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@NamedQueries({
        @NamedQuery(name = "Role.getAll",query = "SELECT r FROM Role r")
})
public class Role  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet = new HashSet<>();

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
