package controller.facade;
import controller.AdminController;
import controller.AuthController;

public class ControllerFacade{

    private static volatile ControllerFacade instance;
    private static Object mutex = new Object();
    /**
     * -------Controllers-----------
     */
    private AuthController authController;
    private AdminController adminController;
    private ControllerFacade() {
    }
    /**
     *---Double check singleton
     */
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
    /**
     *
     * -------controller for Auth actions -----------
     */
    public AuthController getAuthController(){
        authController = new AuthController();
        return authController;
    }
    /**
     *
     * -------controller for Admin Page actions -----------
     */
    public AdminController getAdminController(){
        adminController = new AdminController();
        return adminController;
    }

}
