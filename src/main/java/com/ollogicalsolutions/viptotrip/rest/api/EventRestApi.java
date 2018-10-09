package com.ollogicalsolutions.viptotrip.rest.api;


import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventService;
import com.ollogicalsolutions.viptotrip.services.interfaces.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventRestApi {

    @Autowired
    private EventService eventService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = "/api/event/{eventCode}")
    public Event getEventById(@PathVariable String eventCode) {
        Event event = modelMapper.map(eventService.getEventByCode(eventCode), Event.class);
        return event;
    }

    @GetMapping(path = "/api/event/flights/{eventCode}")
    public List<Flight> getFlightsByEventId(@PathVariable String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<Flight>>() {}.getType();
        List<Flight> flights = modelMapper.map(flightService.getFlightsByEventCode(eventCode), targetListType);
        return flights;
    }


}
