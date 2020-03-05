package repository.impl;

import domain.User;
import repository.FactoryEntityManager;
import repository.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UserRepository implements Repository<User> {
    private final EntityManager entityManager;

    public UserRepository() {
        entityManager = FactoryEntityManager.getInstance().getEntityManager();
    }

    @Override
    public User saveOrUpdate(User entity) {
        entityManager.getTransaction().begin();
        User newUser = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newUser;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.createNamedQuery("User.getById",User.class).setParameter("UserId",id).getSingleResult();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public List<User> getAll() {
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createNamedQuery("User.getAll").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public User getById(Long id) {
        entityManager.getTransaction().begin();
           User user = entityManager.createNamedQuery("User.getById",User.class).setParameter("UserId",id).getSingleResult();
           entityManager.getTransaction().commit();
           entityManager.close();
           return user;

    }

    @Override
    public User findByName(User entity) {
        return null;
    }
}
