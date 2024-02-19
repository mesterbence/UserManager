package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user);
}
