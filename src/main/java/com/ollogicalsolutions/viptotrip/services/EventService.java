package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;
    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public EventService(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDTO createEvent(final EventDTO eventDTO) {
        Event eventEntity = modelMapper.map(eventDTO, Event.class);
        eventRepository.save(eventEntity);
        eventDTO.setId(eventEntity.getId());
        return eventDTO;
    }



    public EventDTO saveEditedEvent(final EventDTO eventDTO) {
        Event eventEntity = modelMapper.map(eventDTO, Event.class);
        eventRepository.save(eventEntity);
        eventDTO.setId(eventEntity.getId());
        return eventDTO;
    }

    public EventDTO getEventByCode(final String eventCode) {
        Event eventEntity = eventRepository.findFirstByCode(eventCode);
        return modelMapper.map(eventEntity, EventDTO.class);
    }
}
