package service;

import domain.User;

import java.util.List;

public interface UserService {
    User insertNewUser(User user);

    List<User> getAll();

    User findById(long id);

    void deleteUser(long l);
}
