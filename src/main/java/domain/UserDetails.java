package domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id_user_details;
    protected String firstName;
    protected String lastName;

    public Long getId_user_details() {
        return id_user_details;
    }

    public void setId_user_details(Long id_user_details) {
        this.id_user_details = id_user_details;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
