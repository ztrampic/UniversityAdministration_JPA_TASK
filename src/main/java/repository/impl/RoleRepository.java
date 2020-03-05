package repository.impl;

import domain.Role;
import repository.FactoryEntityManager;
import repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class RoleRepository implements Repository<Role> {
    private final EntityManager entityManager;

    public RoleRepository() {
        entityManager = FactoryEntityManager.getInstance().getEntityManager();
    }

    @Override
    public Role saveOrUpdate(Role entity) {
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
