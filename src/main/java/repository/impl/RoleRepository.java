package repository.impl;

import domain.Role;
import repository.MyProvider;
import repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RoleRepository implements Repository<Role> {
    @Override
    public Role saveOrUpdate(Role entity) {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        Role role = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return role;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Role> getAll() {
        EntityManager entityManager = MyProvider.getInstance().getManager();
        entityManager.getTransaction().begin();
        List<Role> roles = entityManager.createNamedQuery("Role.getAll").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return roles;
    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role findByName(Role entity) {
        List<Role> roles = getAll();
        for (Role role : roles){
            if(entity.getRoleName().toString().equals(role.getRoleName().toString())){
                return role;
            }
        }
        return entity;
    }
}
