package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import com.ollogicalsolutions.viptotrip.repositories.EventLeaderRepository;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.EventLeaderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EventLeaderServiceImpl implements EventLeaderService {

    private EventLeaderRepository eventLeaderRepository;
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EventLeaderServiceImpl(EventLeaderRepository eventLeaderRepository, EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventLeaderRepository = eventLeaderRepository;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EventLeaderDTO> getEventLeadersByEventCode(String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<EventLeaderDTO>>() {}.getType();
        List<EventLeaderDTO> eventLeaderDTOS = modelMapper.map(eventLeaderRepository.findAllByEvent_Code(eventCode), targetListType);
        return eventLeaderDTOS;
    }

    @Override
    public EventLeader addEventLeaderToEvent(EventLeaderDTO eventLeaderDTO, String eventCode) {
        Event event = eventRepository.findFirstByCode(eventCode);
        eventLeaderDTO.setEvent(event);
        EventLeader eventLeader = modelMapper.map(eventLeaderDTO, EventLeader.class);
        eventLeaderRepository.save(eventLeader);
        return null;
    }

    @Override
    public void deleteEventLeaderById(Long id) {
        eventLeaderRepository.deleteById(id);
    }

    @Override
    public Integer deleteAllEventLeadersByEventCode(String eventCode) {
        Integer leadersDeleted = eventLeaderRepository.deleteAllByEvent_Code(eventCode);
        return leadersDeleted;
    }
}
