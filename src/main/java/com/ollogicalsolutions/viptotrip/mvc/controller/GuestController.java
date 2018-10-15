package com.ollogicalsolutions.viptotrip.mvc.controller;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.repositories.EventLeaderRepository;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.FlightRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import com.ollogicalsolutions.viptotrip.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private EventLeaderRepository eventLeaderRepository;


//    @GetMapping("/show_event")
//    public String addUser(Model model) {
//
//        User user = new User();
//        model.addAttribute("user", user);
//        return "admin";
//    }

    @PostMapping("/show_event")
    public String showEvent(@RequestParam String code, Model model) {

        Event event = eventRepository.findFirstByCode(code);
        List<Flight> flights = flightRepository.findAllByEvent_Code(code);
        List<EventLeader> leaders = eventLeaderRepository.findAllByEvent_Code(code);

        model.addAttribute(event);
        model.addAttribute("leaders", leaders);
        model.addAttribute("flights",flights);
        return ("showevent");
    }
}