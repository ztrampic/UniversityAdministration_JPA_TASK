package controller;

import domain.User;
import dto.StudentDtoRequest;
import dto.UserCredentials;
import dto.UserDtoResponse;

public class ControllerFacade{
    private final AuthController authController;
    public ControllerFacade() {
        authController = new AuthController();
    }

    public UserDtoResponse authLogin(UserCredentials credentials) {
        UserDtoResponse userDtoResponse = authController.login(credentials);
        return userDtoResponse;
    }

    public void authRegistrate(StudentDtoRequest studentDtoRequest) {
        authController.registrate(studentDtoRequest);
    }
}
