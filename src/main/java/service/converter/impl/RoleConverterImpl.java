package service.converter.impl;

import domain.Role;
import enums.RoleName;
import service.converter.RoleConverter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleConverterImpl implements RoleConverter {
    @Override
    public Set<RoleName> convertToDtoRoleName(Set<Role> roleSet) {
        Set<RoleName> roleNames = new HashSet<>();
        roleSet.stream().forEach(role -> roleNames.add(role.getRoleName()));
        return roleNames;
    }
}
