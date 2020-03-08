package service.converter.impl;

import domain.User;
import dto.UserDtoResponse;
import service.converter.RoleConverter;
import service.converter.UserConverter;
import service.converter.UserDetailsConverter;

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
}
