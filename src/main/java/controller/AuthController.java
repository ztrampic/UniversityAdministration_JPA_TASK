package controller;

import domain.User;
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

    public void deleteUser(long l) {
        userService.deleteUser(l);
    }

    public UserDtoResponse login(UserCredentials credentials) {
        User user = userService.login(credentials);
        if(user == null) return null;
        UserDtoResponse userDtoResponse = userConverter.convertToUserDtoResponse(user);
        return userDtoResponse;
    }

    public void registrate(StudentDtoRequest studentDtoRequest) {
        // --------- in proggresss --------------
        //User user = userConverter.convertToUser(studentDtoRequest);
        userService.insertNewUser(user);
    }
}

