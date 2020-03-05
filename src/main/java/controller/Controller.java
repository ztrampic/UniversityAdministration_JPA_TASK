package controller;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.List;

public class Controller {
    private static volatile Controller instance;
    private static Object mutex = new Object();
    private final UserService userService;

    private Controller() {
        userService = new UserServiceImpl();
    }

    public static Controller getInstance() {
        Controller result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = new Controller();
                }
            }
        }
        return instance;
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
}

