package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
