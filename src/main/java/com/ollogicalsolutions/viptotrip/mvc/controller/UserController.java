package com.ollogicalsolutions.viptotrip.mvc.controller;


import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/userform";
    }

    @PostMapping("/add")
    @ResponseBody
    public String user(@ModelAttribute User user) {
        userRepository.save(user);
        return user.toString();
    }

}
