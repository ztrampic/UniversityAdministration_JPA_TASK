package controller;

import domain.Professor;
import domain.User;
import dto.ProfessorDtoRequest;
import dto.StudentDtoRequest;
import dto.UserCredentials;
import dto.UserDtoResponse;
import service.UserService;
import service.converter.UserConverter;
import service.converter.impl.UserConverterImpl;
import service.impl.UserServiceImpl;

import java.util.List;

public class AuthController {
    private final UserService userService;
    private final UserConverter userConverter;

    public AuthController() {
        userService = new UserServiceImpl();
        userConverter = new UserConverterImpl();
    }

    public void getAllUsers() {
        List<User> users = userService.getAll();
    }

    public void findUserById(long id) {
        User user = userService.findById(id);
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    public UserDtoResponse login(UserCredentials credentials) {
        User user = userService.login(credentials);
        if(user == null) return null;
        UserDtoResponse userDtoResponse = userConverter.convertToUserDtoResponse(user);
        return userDtoResponse;
    }

    public void registrate(StudentDtoRequest studentDtoRequest) throws Exception {
        User user = userConverter.convertToUser(studentDtoRequest);
        User newUser = userService.insertNewUser(user);
    }

    public ProfessorDtoRequest registrateProfessor(ProfessorDtoRequest professorDtoRequest) throws Exception {
        User user = userConverter.convertToUserProfessor(professorDtoRequest);
        User newUser = userService.insertNewUser(user);
        ProfessorDtoRequest newProfessorDto = new ProfessorDtoRequest();
        return newProfessorDto;
    }
}

