package com.example.demo.Controller;

import com.example.demo.Security.Details.UserDetailsImpl;
import com.example.demo.Transfer.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping(path = "/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserDTO user = UserDTO.from(userDetails.getUser());
        model.addAttribute("user", user);
        return "profile";
    }
}
