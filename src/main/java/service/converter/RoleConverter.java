package service.converter;

import domain.Role;
import enums.RoleName;

import java.util.Set;

public interface RoleConverter {
    Set<RoleName> convertToDtoRoleName(Set<Role> roleSet);
}
