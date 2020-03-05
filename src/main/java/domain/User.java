package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.getAll",query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.getById", query = "SELECT u FROM User u WHERE u.id_user = :UserId"),
})
public class User implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String userName;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserDetails UserDetails;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roleSet = new HashSet<>();

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public domain.UserDetails getUserDetails() {
        return UserDetails;
    }

    public void setUserDetails(domain.UserDetails userDetails) {
        UserDetails = userDetails;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public void addRole(Role role){
        roleSet.add(role);
        role.getUserSet().add(this);
    }

    public void removeRole(Role role){
        roleSet.remove(role);
        role.getUserSet().remove(this);
    }


}
