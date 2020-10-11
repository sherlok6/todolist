package com.example.demo.Service.Impl;

import com.example.demo.Form.UserForm;
import com.example.demo.Model.User.Role;
import com.example.demo.Model.User.State;
import com.example.demo.Model.User.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SingUpServiceImpl implements SignUpService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void signUp(UserForm form) {
        String hashPass = encoder.encode(form.getPassword());
        repository.save(
                User.builder()
                        .firstName(form.getFirstName())
                        .lastName(form.getLastName())
                        .hashPass(hashPass)
                        .login(form.getLogin())
                        .role(Role.USER)
                        .state(State.ACTIVE)
                        .build()
        );
    }
}
