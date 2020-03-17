package repository.impl;

import domain.Department;
import repository.MyProvider;
import repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentRepository implements Repository<Department> {
    @Override
    public Department saveOrUpdate(Department entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Department department = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return department;
    }

    @Override
    public void delete(Department entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Department department = entityManager.find(Department.class,entity.getId_department());
        entityManager.remove(department);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Department> getAll() {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        List<Department> departments = entityManager.createNamedQuery("Department.getAll").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return departments;
    }

    @Override
    public Department getById(Long id) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Department department = entityManager.createNamedQuery("Department.findById", Department.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return department;
    }

    @Override
    public Department findByName(Department entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Department foundDepartment = entityManager.createNamedQuery("Department.findByName", Department.class).setParameter("name", entity.getName()).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return foundDepartment;
    }
}
