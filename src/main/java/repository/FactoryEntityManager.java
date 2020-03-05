package repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
    private static volatile FactoryEntityManager instance;
    private static Object mutex = new Object();
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private FactoryEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("zadatak");
    }

    public static FactoryEntityManager getInstance() {
        FactoryEntityManager result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = new FactoryEntityManager();
                }
            }
        }
        return instance;
    }
    public EntityManager getEntityManager(){
        entityManager = entityManagerFactory.createEntityManager();
        return  entityManager;
    }
}
