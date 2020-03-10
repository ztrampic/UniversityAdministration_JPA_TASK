package repository.impl;

import domain.Faculty;
import domain.User;
import repository.MyProvider;
import repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class FacultyRepository implements Repository<Faculty> {

    @Override
    public Faculty saveOrUpdate(Faculty entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Faculty faculty = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return faculty;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Faculty> getAll() {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        List<Faculty> faculties = entityManager.createNamedQuery("Faculty.getAll").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return faculties;
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
