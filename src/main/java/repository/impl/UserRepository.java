package repository.impl;

import domain.User;
import repository.FactoryEntityManager;
import repository.Repository;

import javax.persistence.EntityManager;
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
    public void deleteById(Long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }
}
