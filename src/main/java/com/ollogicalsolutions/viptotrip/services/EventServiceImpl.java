package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EventServiceImpl(final EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
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
        if (eventEntity != null)
            return modelMapper.map(eventEntity, EventDTO.class);
        else
            return null;
    }
}
