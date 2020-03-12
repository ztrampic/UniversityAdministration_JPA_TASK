package service;

import domain.User;
import dto.UserCredentials;

import java.util.List;

public interface UserService {
    User insertNewUser(User user);

    List<User> getAll();

    User findById(long id);

    void deleteUser(User user);

    User login(UserCredentials credentials);
}
