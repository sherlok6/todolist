package com.example.demo.Service.Impl;

import com.example.demo.Model.User.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public void delete(Long id) {
        repository.deleteId(id);
    }

    @Override
    public void save(User user) {
    }
}
