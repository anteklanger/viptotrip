package com.ollogicalsolutions.viptotrip.mvc.controller;

import com.ollogicalsolutions.viptotrip.entities.*;
import com.ollogicalsolutions.viptotrip.repositories.*;

import com.ollogicalsolutions.viptotrip.services.GuestsCreator;
import com.ollogicalsolutions.viptotrip.services.dto.AgendaEntryDTO;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import com.ollogicalsolutions.viptotrip.services.dto.FlightDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.AgendaEntryService;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventLeaderService;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventService;
import com.ollogicalsolutions.viptotrip.services.interfaces.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

//    @Autowired
//    private EventRepository eventRepository;
//    @Autowired
//    private EventLeaderRepository eventLeaderRepository;
//    @Autowired
//    private FlightRepository flightRepository;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AgendaEntryRepository agendaEntryRepository;
    @Autowired
    private GuestsCreator guestsCreator;

//    @Autowired
//    private EventServiceImpl eventServiceImpl;
    @Autowired
    private EventService eventService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private EventLeaderService eventLeaderService;

    @Autowired
    AgendaEntryService agendaEntryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    Validator validator;

    @GetMapping("/new_event")
    public String showForm(Model model) {
        model.addAttribute("event", new EventDTO());
        return "event";
    }

    @PostMapping("/new_event")
    public String saveBaseEvent(@Valid @ModelAttribute EventDTO eventDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            List<String> messages = new ArrayList<>();
            for (ObjectError e : errors
            ) {
                messages.add(e.getDefaultMessage());
            }
            model.addAttribute("event", eventDTO);
            model.addAttribute("errorsList", messages);
            model.addAttribute("eventexists", "");
            return "event";
        } else {

            if (eventService.getEventByCode(eventDTO.getCode()) != null) {
                model.addAttribute("event", eventDTO);
                model.addAttribute("eventexists", "EVENT O PODANYM KODZIE JUŻ ISTNIEJE");
                return "event";
            } else {
                eventService.createEvent(eventDTO);
                model.addAttribute("event", eventDTO);
                return ("eventaddsucces");
            }
        }
    }

    @GetMapping("/edit_event/{eventCode}")
    public String editBaseData(@PathVariable String eventCode, Model model) {
        EventDTO eventDTO = eventService.getEventByCode(eventCode);
        model.addAttribute("event", eventDTO);
        return "eventedit";
    }

    @PostMapping("/edit_event/{eventCode}")
    public String editMenu(@PathVariable String eventCode, @ModelAttribute EventDTO eventDTO, Model model) {
        eventDTO.setId(eventService.getEventByCode(eventCode).getId());
        eventDTO.setCode(eventCode);
        eventDTO.setEventCategory(eventService.getEventByCode(eventCode).getEventCategory());
        eventService.saveEditedEvent(eventDTO);
        model.addAttribute("event", eventDTO);

        return "eventeditmenu";
    }

    @GetMapping("/delete_event/{eventCode}")
    public String deleteEvent(@PathVariable String eventCode, Model model) {
        model.addAttribute("eventCode", eventCode);
        return "deleteevent";
    }

    @GetMapping("delete_event_success/{eventCode}")
    public String confirmDeletion(@PathVariable String eventCode, Model model) {
        Integer delCode = eventService.deleteEventByCode(eventCode);

        System.out.println(delCode);

        model.addAttribute("eventCode", eventCode);
        return "deleteeventsuccess";
    }


    @GetMapping("add_leaders/{eventCode}")
    public String addLeaders(@PathVariable String eventCode, Model model) {
        EventLeaderDTO eventLeaderDTO = new EventLeaderDTO();
        eventLeaderDTO.setEvent(modelMapper.map(eventService.getEventByCode(eventCode), Event.class));
        model.addAttribute("eventLeader", eventLeaderDTO);
        model.addAttribute("allLeaders", eventLeaderService.getEventLeadersByEventCode(eventCode));
        return "eventleader";
    }

    @PostMapping("add_leaders/{eventCode}")
    public String leaderAddedSuccess(@ModelAttribute EventLeaderDTO eventLeaderDTO, @PathVariable String eventCode, Model model) {
        eventLeaderDTO.setEvent(modelMapper.map(eventService.getEventByCode(eventCode), Event.class));
        eventLeaderService.addEventLeaderToEvent(eventLeaderDTO, eventCode);
        List<EventLeaderDTO> leaderDTOS = eventLeaderService.getEventLeadersByEventCode(eventCode);
        model.addAttribute("leaders", leaderDTOS);
        model.addAttribute("eventCode", eventCode);
        return ("leaderaddsucces");
    }


    @GetMapping("add_flight/{eventCode}")
    public String addFlights(@PathVariable String eventCode, Model model) {
        FlightDTO flight = new FlightDTO();
        flight.setEvent(modelMapper.map(eventService.getEventByCode(eventCode), Event.class)); //TODO check
        model.addAttribute("flight", flight);
        model.addAttribute("flights", flightService.getFlightsByEventCode(eventCode));
        return "flight";
    }

    @PostMapping("add_flight/{eventCode}")
    public String flightAddedSuccess(@ModelAttribute FlightDTO flight, @PathVariable String eventCode, Model model) {
        flightService.addFlightToEvent(flight, eventCode);
        List<FlightDTO> flights = flightService.getFlightsByEventCode(eventCode);
        model.addAttribute("flights", flights);
        model.addAttribute("eventCode", eventCode);
        return ("flightsucces");
    }

    @GetMapping("add_agenda/{eventCode}")
    public String addAgendaEntry(@PathVariable String eventCode, Model model) {
        AgendaEntryDTO agendaEntryDTO = new AgendaEntryDTO();
        agendaEntryDTO.setEvent(modelMapper.map(eventService.getEventByCode(eventCode), Event.class));
        model.addAttribute("agenda", agendaEntryDTO);
        model.addAttribute("allAgendaEntries", agendaEntryService.getAllAgendaEntriesByEventCodeOrderByPosition(eventCode));
        return "agenda";
    }

    @PostMapping("add_agenda/{eventCode}")
    public String agendaAddedSuccess(@ModelAttribute AgendaEntryDTO agendaEntryDTO, @PathVariable String eventCode, Model model) {
        agendaEntryDTO.setEvent(modelMapper.map(eventService.getEventByCode(eventCode), Event.class));
        agendaEntryService.addAgendaEntryToEvent(agendaEntryDTO, eventCode);
        List<AgendaEntryDTO> agendaEntryDTOS = agendaEntryService.getAllAgendaEntriesByEventCodeOrderByPosition(eventCode);
        model.addAttribute("agenda", agendaEntryDTOS);
        model.addAttribute("eventCode", eventCode);
        return ("agendasuccess");
    }

    @GetMapping("delete_agenda/{eventCode}/{id}")
    public String agendaDeleteEntry(@PathVariable String id, @PathVariable String eventCode, Model model) {
        agendaEntryService.deleteAgendaEntryById(Long.parseLong(id));
        List<AgendaEntryDTO> agendaEntries = agendaEntryService.getAllAgendaEntriesByEventCodeOrderByPosition(eventCode);
        model.addAttribute("agenda", agendaEntries);
        model.addAttribute("eventCode", eventCode);
        return ("agendasuccess");
    }

    @GetMapping("add_guests/{eventCode}")
    public String addGuests(@PathVariable String eventCode, Model model) {
        String guests = null;
        model.addAttribute("guests", guests);
        model.addAttribute("eventCode", eventCode);
        return "guests";
    }

    @PostMapping("add_guests/{eventCode}")
    public String addGuestsSuccess(@PathVariable String eventCode, @RequestParam String list, Model model) {
        guestsCreator.createListOfGuestsForEvent(eventCode, list);
        List<User> users = userRepository.findAllByEvent_Code(eventCode);
        model.addAttribute("guests", users);
        model.addAttribute("event", eventService.getEventByCode(eventCode));
        return "guestssucces";
    }

}

