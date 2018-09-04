package com.ollogicalsolutions.viptotrip.mvc.controller;

import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        String username = user.getUsername();
        User alreadyRegisterUser = userRepository.
                findFirstByUsernameAllIgnoreCase(username);
        if (alreadyRegisterUser != null) {
            return "redirect:/register?alreadyExists=true";
        }
        user.setPin(passwordEncoder.encode(user.getPin()));

        String password = "123";
        passwordEncoder.matches(password, user.getPin());
        userRepository.save(user);
        return "redirect:/";
    }
}
