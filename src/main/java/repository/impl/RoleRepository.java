package repository.impl;

import domain.Role;
import domain.User;
import enums.RoleName;
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
    public void deleteById(Long id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role findByName(Role entity) {
        List<Role> roles = entityManager.createNativeQuery("select * from role",Role.class).getResultList();
        for (Role role : roles){
            if(entity.getRoleName().toString().equals(role.getRoleName().toString())){
                return role;
            }
        }
        return entity;
    }
}
