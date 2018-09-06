package com.ollogicalsolutions.viptotrip.mvc.controller;

import com.ollogicalsolutions.viptotrip.entities.Message;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.MessageRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import com.ollogicalsolutions.viptotrip.services.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/add_user")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("add_user")
    public String addUserSuccess(@ModelAttribute User user, Model model) {

        List<String> roles = new ArrayList<>();

        if (user.getAdminVip()) roles.add("ADMIN");
        if ((user.getEditorVip())) roles.add("EDITOR");
        if ((user.getGuestVip())) roles.add("GUEST");


        userService.saveUser(user, roles);
//        if(user.getEditorVip()) userService.saveUser(user, "EDITOR");


//        userRepository.save(user);
        List<User> editors = userRepository.findAllByEditorVip(true);
        List<User> admins = userRepository.findAllByAdminVip(true);

        model.addAttribute("admins", admins);
        model.addAttribute("editors", editors);

        return ("adminsuccess");
    }
}
