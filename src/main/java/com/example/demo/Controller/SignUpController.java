package com.example.demo.Controller;

import com.example.demo.Form.UserForm;
import com.example.demo.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping(path = "/signup")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping(path = "/signup")
    public String singUp(UserForm form) {
        service.signUp(form);
        return "redirect:/login";
    }
}
