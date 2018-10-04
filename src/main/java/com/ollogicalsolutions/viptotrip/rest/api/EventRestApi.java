package com.ollogicalsolutions.viptotrip.rest.api;


import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventRestApi {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/api/event/{eventCode}")
    public Event getEventById(@PathVariable String eventCode) {
        Event event = eventRepository.findFirstByCode(eventCode);
        return event;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/event/flight/{eventCode}")
    public List<Flight> getFlightsByEventId(@PathVariable String eventCode) {
        List<Flight> flights = flightRepository.findAllByEvent_Code(eventCode);
        return flights;
    }


}
