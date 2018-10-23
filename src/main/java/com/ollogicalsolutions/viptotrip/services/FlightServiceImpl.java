package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.FlightRepository;
import com.ollogicalsolutions.viptotrip.services.dto.FlightDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, EventRepository eventRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FlightDTO> getFlightsByEventCode(String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<FlightDTO>>() {}.getType();
        List<FlightDTO> flightDTOS = modelMapper.map(flightRepository.findAllByEvent_Code(eventCode), targetListType);
        return flightDTOS;
    }

    @Override
    public FlightDTO addFlightToEvent(FlightDTO flightDTO, String eventCode) {
        Event event = eventRepository.findFirstByCode(eventCode);
        flightDTO.setEvent(event);
        Flight flightEntity = modelMapper.map(flightDTO, Flight.class);
        flightRepository.save(flightEntity);
        return flightDTO;
    }

    @Override
    public Integer deleteFlightById(Long id) {
        flightRepository.deleteById(id);
        return null;
    }

    @Override
    public Integer deleteAllFlightsByEventCode(String eventCode) {
        Integer flightsDeleted = flightRepository.deleteAllByEvent_Code(eventCode);
        return flightsDeleted;
    }
}
