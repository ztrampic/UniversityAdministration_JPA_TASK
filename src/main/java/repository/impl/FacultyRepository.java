package repository.impl;

import domain.Faculty;
import domain.User;
import repository.FactoryEntityManager;
import repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class FacultyRepository implements Repository<Faculty> {
    private final EntityManager entityManager;
    public FacultyRepository() {
        entityManager = FactoryEntityManager.getInstance().getEntityManager();
    }
    @Override
    public Faculty saveOrUpdate(Faculty entity) {
        entityManager.getTransaction().begin();
        Faculty faculty = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return faculty;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Faculty> getAll() {
        return null;
    }

    @Override
    public Faculty getById(Long id) {
        return null;
    }

    @Override
    public Faculty findByName(Faculty entity) {
        return null;
    }
}
