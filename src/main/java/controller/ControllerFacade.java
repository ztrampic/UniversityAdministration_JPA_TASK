package controller;
import dto.*;
import repository.MyProvider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ControllerFacade{

    private static volatile ControllerFacade instance;
    private static Object mutex = new Object();
//    ----controllers-----
    private AuthController authController;
    private AdminController adminController;
    private ControllerFacade() {
    }
    public static ControllerFacade getInstance() {
        ControllerFacade facade = instance;
        if (facade == null) {
            synchronized (mutex) {
                facade = instance;
                if (facade == null) {
                    instance = new ControllerFacade();
                }
            }
        }
        return instance;
    }

    public AuthController getAuthController(){
        authController = new AuthController();
        return authController;
    }

    public AdminController getAdminController(){
        adminController = new AdminController();
        return adminController;
    }

}
