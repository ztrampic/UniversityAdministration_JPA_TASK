package service.converter.impl;

import domain.Role;
import domain.User;
import dto.StudentDtoRequest;
import dto.UserDtoResponse;
import enums.RoleName;
import service.converter.RoleConverter;
import service.converter.UserConverter;
import service.converter.UserDetailsConverter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserConverterImpl implements UserConverter {
    private final RoleConverter roleConverter;
    private final UserDetailsConverter userDetailsConverter;

    public UserConverterImpl() {
        roleConverter = new RoleConverterImpl();
        userDetailsConverter = new UserDetailsConverterImpl();
    }

    @Override
    public UserDtoResponse convertToUserDtoResponse(User user) {
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setIdUser(user.getId_user());
        userDtoResponse.setUserName(user.getUserName());
        userDtoResponse.setRoleNames(roleConverter.convertToDtoRoleName(user.getRoleSet()));
        userDtoResponse.setUserDetailsDto(userDetailsConverter.convertToDto(user.getUserDetails()));
        return userDtoResponse;
    }

    @Override
    public User convertToUser(StudentDtoRequest studentDtoRequest) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName(RoleName.STUDENT);
        roles.add(role);
        user.setRoleSet(roles);
        user.setUserDetails(userDetailsConverter.convertToStudentEntity(studentDtoRequest.getUserDetailsDto()));
        user.setUserName(studentDtoRequest.getUserName());
        user.setPassword(studentDtoRequest.getPassword());
        return user;
    }
}
