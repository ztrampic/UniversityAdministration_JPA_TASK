package service.impl;

import domain.Role;
import domain.User;
import repository.Repository;
import repository.impl.RoleRepository;
import repository.impl.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final Repository<User> userRepository;
    private final Repository<Role> roleRepository;

    public UserServiceImpl() {
        userRepository = new UserRepository();
        roleRepository = new RoleRepository();
    }

    @Override
    public User insertNewUser(User user) {
        Role role = roleRepository.findByName(user.getRoleSet().stream().findFirst().get());
        user.getRoleSet().clear();
        user.addRole(role);
        User newUser = userRepository.saveOrUpdate(user);
        return newUser;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }
}
