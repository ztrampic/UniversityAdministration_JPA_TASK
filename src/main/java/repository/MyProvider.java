package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyProvider {
    private static volatile MyProvider instance;
    private static Object mutex = new Object();
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityAdministration");
    private MyProvider() {
    }

    public static MyProvider getInstance() {
        MyProvider result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = new MyProvider();
                }
            }
        }
        return instance;
    }
    public EntityManager getManager(){
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
