package dto;

import enums.RoleName;
import java.util.Set;

public class UserDtoResponse {
    private Long idUser;
    private String userName;
    private UserDetailsDto userDetailsDto;
    private Set<RoleName> roleNames;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public Set<RoleName> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(Set<RoleName> roleNames) {
        this.roleNames = roleNames;
    }
}
