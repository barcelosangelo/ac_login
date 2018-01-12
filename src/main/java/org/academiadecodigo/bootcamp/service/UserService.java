package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

public interface UserService {

    boolean authenticate(String username, String password);

    void addUser(User user);

    User findByName(String username);

    int count();

}
