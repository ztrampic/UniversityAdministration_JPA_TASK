package repository.impl;

import domain.User;
import repository.MyProvider;
import repository.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepository implements Repository<User> {


    @Override
    public User saveOrUpdate(User entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        User newUser = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newUser;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        User user = entityManager.createNamedQuery("User.getById",User.class).setParameter("UserId",id).getSingleResult();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public List<User> getAll() {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createNamedQuery("User.getAll").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public User getById(Long id) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        User user = entityManager.createNamedQuery("User.getById", User.class).setParameter("UserId", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;

    }

    @Override
    public User findByName(User entity) {
        return null;
    }
}
