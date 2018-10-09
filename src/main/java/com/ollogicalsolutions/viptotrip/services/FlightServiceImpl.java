package com.ollogicalsolutions.viptotrip.services;

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
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FlightDTO> getFlightsByEventCode(String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<FlightDTO>>() {}.getType();
        List<FlightDTO> flightDTOS = modelMapper.map(flightRepository.findAllByEvent_Code(eventCode), targetListType);
        return flightDTOS;
    }

    @Override
    public FlightDTO createFlight(FlightDTO flightDTO, String eventCode) {
        Flight flightEntity = modelMapper.map(flightDTO, Flight.class);
        flightRepository.save(flightEntity);
        flightDTO.setEvent(eventRepository.findFirstByCode(eventCode));
        return flightDTO;
    }
}
