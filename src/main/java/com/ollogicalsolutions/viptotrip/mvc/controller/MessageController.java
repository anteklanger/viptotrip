package com.ollogicalsolutions.viptotrip.mvc.controller;

import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import com.ollogicalsolutions.viptotrip.entities.Message;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.*;
import com.ollogicalsolutions.viptotrip.services.GuestsCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("add_message/{eventCode}")
    public String addMessage(@PathVariable String eventCode, Model model) {
        Message message = new Message();
        message.setEvent(eventRepository.findFirstByCode(eventCode));
        model.addAttribute(message);
        List<Message> messages = messageRepository.findAllByEvent_Code(eventCode);
        model.addAttribute("messages", messages);

        return "addnewstoevent";
    }

    @PostMapping("add_message/{eventCode}")
    public String addMessageSuccess(@ModelAttribute Message message, @PathVariable String eventCode, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        message.setEvent(eventRepository.findFirstByCode(eventCode));
        message.setUser(user);
        message.setAuthorCategory("editor");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = now.format(formatter);
        message.setCreated(formatDateTime);
        message.setCategory("news");
        messageRepository.save(message);
        List<Message> messages = messageRepository.findAllByEvent_Code(eventCode);
        model.addAttribute("messages", messages);
        model.addAttribute("eventCode", eventCode);
        return ("addnewstoeventsuccess");
    }

    @GetMapping("delete_message/{eventCode}/{id}")
    public String agendaDeleteEntry(@PathVariable String id, @PathVariable String eventCode, Model model) {
        messageRepository.delete( messageRepository.getOne(Long.parseLong(id)));
        List<Message> messages = messageRepository.findAllByEvent_CodeOrderByCreated(eventCode);
        model.addAttribute("messages", messages);
        model.addAttribute("eventCode", eventCode);

//        String redirect = "redirect:/message/add_message/" + eventCode;
        return "addnewstoeventsuccess";
    }


}
