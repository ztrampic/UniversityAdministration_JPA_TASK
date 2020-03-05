package domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_details;
    private String userName;
    private String lastName;

    public Long getId_user_details() {
        return id_user_details;
    }

    public void setId_user_details(Long id_user_details) {
        this.id_user_details = id_user_details;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
