package service.impl;

import domain.Role;
import domain.User;
import dto.UserCredentials;
import enums.Messages;
import repository.Repository;
import repository.impl.AuthRepository;
import repository.impl.RoleRepository;
import repository.impl.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final Repository<User> userRepository;
    private final Repository<Role> roleRepository;
    private final AuthRepository authRepository;

    public UserServiceImpl() {
        userRepository = new UserRepository();
        roleRepository = new RoleRepository();
        authRepository = new AuthRepository();
    }

    @Override
    public User insertNewUser(User user) throws Exception {
        Role role = roleRepository.findByName(user.getRoleSet().stream().findFirst().get());
        user.getRoleSet().clear();
        user.addRole(role);
        try {
            User newUser = userRepository.saveOrUpdate(user);
            return newUser;
        }catch (Exception e){
            throw new Exception(Messages.USERNAME_ALREADY_EXIST.getMessage());
        }
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
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User login(UserCredentials credentials) {
        User user = authRepository.login(credentials);
        return user;
    }
}
