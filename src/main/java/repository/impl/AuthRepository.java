package repository.impl;

import domain.User;
import dto.UserCredentials;
import repository.MyProvider;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AuthRepository {

    public User login(UserCredentials credentials) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.createNamedQuery("User.checkCredentails", User.class)
                    .setParameter("Password", credentials.getPassword())
                    .setParameter("Username", credentials.getUsername()).getSingleResult();
            entityManager.getTransaction().commit();
            return user;
        } catch (NoResultException e) {
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }
}
