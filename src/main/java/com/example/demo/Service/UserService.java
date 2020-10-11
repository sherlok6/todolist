package com.example.demo.Service;

import com.example.demo.Model.User.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByLogin(String login);

    void delete(Long id);

    void save(User user);
}
