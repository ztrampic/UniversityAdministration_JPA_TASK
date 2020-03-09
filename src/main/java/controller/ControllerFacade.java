package controller;

import domain.Faculty;
import domain.User;
import dto.FacultyDto;
import dto.StudentDtoRequest;
import dto.UserCredentials;
import dto.UserDtoResponse;

public class ControllerFacade{
    private final AuthController authController;
    private final AdminController adminController;
    public ControllerFacade() {
        authController = new AuthController();
        adminController = new AdminController();
    }

    public UserDtoResponse authLogin(UserCredentials credentials) {
        UserDtoResponse userDtoResponse = authController.login(credentials);
        return userDtoResponse;
    }

    public void authRegistrate(StudentDtoRequest studentDtoRequest) {
        authController.registrate(studentDtoRequest);
    }

    public void newFaculty(FacultyDto facultyDto) {
        adminController.insertNewFaculty(facultyDto);
    }

    public FacultyDto getFacultyInfo() {
        FacultyDto facultyDto = adminController.getFaculty();
        return facultyDto;
    }
}
