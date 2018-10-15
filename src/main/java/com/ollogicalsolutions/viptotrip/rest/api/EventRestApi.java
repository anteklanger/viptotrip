package com.ollogicalsolutions.viptotrip.rest.api;


import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.rest.api.exception.EventNotFoundException;
import com.ollogicalsolutions.viptotrip.rest.api.exception.FlightsNotFoundException;
import com.ollogicalsolutions.viptotrip.rest.api.rest_entities.EventRestEntity;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventService;
import com.ollogicalsolutions.viptotrip.services.interfaces.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventRestApi {

    @Autowired
    private EventService eventService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = "/event/{eventCode}")
    public EventRestEntity getEventById(@PathVariable String eventCode) {
        EventDTO eventDTO = eventService.getEventByCode(eventCode);
        if (eventDTO == null) throw new EventNotFoundException("Event with code " + eventCode + " not found");
        EventRestEntity event = modelMapper.map(eventService.getEventByCode(eventCode), EventRestEntity.class);
        return event;
    }

    @GetMapping(path = "/event/flights/{eventCode}")
    public List<Flight> getFlightsByEventId(@PathVariable String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<Flight>>() {}.getType();
        List<Flight> flights = modelMapper.map(flightService.getFlightsByEventCode(eventCode), targetListType);
        if (flights.size() == 0) throw new FlightsNotFoundException("Flights for event " + eventCode + " not found");
        return flights;
    }


}
