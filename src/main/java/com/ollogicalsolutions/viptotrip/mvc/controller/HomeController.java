package com.ollogicalsolutions.viptotrip.mvc.controller;


import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String test(Model model, HttpServletRequest request) {

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean admin = request.isUserInRole("ADMIN");
        boolean admin2 = request.isUserInRole("ROLE_ADMIN");

        User user = userRepository.findByUsername(userName);

        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        model.addAttribute("user", user);
//        User user = new User();
//        user.setUsername("Edytor Pierwszy");
//        user.setPin("1234");
//        user.setId(22L);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

}

