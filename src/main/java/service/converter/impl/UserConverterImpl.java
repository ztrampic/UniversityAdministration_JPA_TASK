package service.converter.impl;

import domain.Department;
import domain.Professor;
import domain.Role;
import domain.User;
import dto.*;
import enums.RoleName;
import service.converter.DepartmentConverter;
import service.converter.RoleConverter;
import service.converter.UserConverter;
import service.converter.UserDetailsConverter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserConverterImpl implements UserConverter {
    private final RoleConverter roleConverter;
    private final UserDetailsConverter userDetailsConverter;
    private final HelperDto helperDto;
    private final DepartmentConverter departmentConverter;

    public UserConverterImpl() {
        roleConverter = new RoleConverterImpl();
        userDetailsConverter = new UserDetailsConverterImpl();
        helperDto = new HelperDto();
        departmentConverter = new DepartmentConverterImpl();
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

    @Override
    public User convertToUserProfessor(ProfessorDtoRequest professorDtoRequest) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName(RoleName.PROFESOR);
        roles.add(role);
        user.setRoleSet(roles);
        user.setUserDetails(userDetailsConverter.convertToProfessorEntity(professorDtoRequest.getUserDetailsDto()));
        user.setUserName(professorDtoRequest.getUserName());
        user.setPassword(professorDtoRequest.getPassword());
        return user;
    }
    @Override
    public ProfessorDtoResponse convertToProfessorDto(Professor professor) {
        ProfessorDtoResponse professorDtoResponse = new ProfessorDtoResponse();
        professorDtoResponse.setId(professor.getId_user_details());
        professorDtoResponse.setDateOfEmployment(helperDto.formatDateToString(professor.getWorkingStarted()));
        professorDtoResponse.setFirstName(professor.getFirstName());
        professorDtoResponse.setLastName(professor.getLastName());
        professorDtoResponse.setTitle(professor.getTitle().toString());
        professorDtoResponse.setDepartmentDto(departmentConverter.convertToDto(professor.getDepartment()));
        return professorDtoResponse;
    }

    @Override
    public Set<ProfessorDtoResponse> convertSetToSetProfessorDto(Set<Professor> professors) {
        Set<ProfessorDtoResponse> professorDtoResponses = professors.stream().map(professor -> {
            ProfessorDtoResponse professorDtoResponse = convertToProfessorDto(professor);
            return professorDtoResponse;
        }).collect(Collectors.toSet());
        return professorDtoResponses;
    }
}
