package com.ollogicalsolutions.viptotrip.mvc.controller;


import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/index")
    public String test(Model model, HttpServletRequest request) {

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean admin = request.isUserInRole("ADMIN");
        boolean admin2 = request.isUserInRole("ROLE_ADMIN");

        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        User user = new User();
        user.setUsername("Edytor Pierwszy");
        user.setPin("1234");
        user.setId(22L);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "index";
    }

}

