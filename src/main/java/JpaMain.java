import domain.*;
import enums.RoleName;
import enums.Title;
import service.FacultyService;
import service.UserService;
import service.impl.FacultyServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Date;

public class JpaMain {

    public static void main(String[] args) {
        System.out.println("TEST");
        JpaMain main = new JpaMain();
//        main.insertFaculty();
           main.insertNewUser();
        //main.getAllUsers();
        //main.findUserById(2L);
        //main.deleteUser(1L);
    }

//    private void deleteUser(long l) {
//        AuthController.getInstance().deleteUser(l);
//    }
//
//    private void findUserById(long id) {
//        AuthController.getInstance().findUserById(id);
//    }
//
//    private void getAllUsers() {
//        AuthController.getInstance().getAllUsers();
//    }

    private void insertNewUser() {
        Professor professor = new Professor();
        professor.setLastName("Peric");
        professor.setFirstName("Pera");
        professor.setTitle(Title.RESEARCHERS);
        professor.setWorkingStarted(new Date());
        Role role = new Role();
        role.setRoleName(RoleName.PROFESOR);
        User user = new User();
        user.setPassword("Pera");
        user.setUserName("pera");
        user.addRole(role);
        user.setUserDetails(professor);
        UserService userService = new UserServiceImpl();
        User newUser = userService.insertNewUser(user);
        System.out.println(newUser.toString());

    }

    private void insertFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("Singidunum");
        faculty.setAddress("Danijelova/39");
        FacultyService facultyService = new FacultyServiceImpl();
        facultyService.saveOrUpdateFaculty(faculty);
    }
}
