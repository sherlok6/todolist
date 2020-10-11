package com.example.demo.Controller;

import com.example.demo.Model.User.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
class UsersController {
    @Autowired
    private UserService service;

    @RequestMapping(path = "/users")
    public String viewUsers(Model model) {
        List<User> userList = service.findAll();
        model.addAttribute("users", userList);
        return "users";
    }

}
