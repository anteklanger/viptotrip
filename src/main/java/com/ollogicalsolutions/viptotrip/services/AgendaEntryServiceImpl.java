package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.AgendaEntry;
import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.Flight;
import com.ollogicalsolutions.viptotrip.repositories.AgendaEntryRepository;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.services.dto.AgendaEntryDTO;
import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import com.ollogicalsolutions.viptotrip.services.dto.FlightDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.AgendaEntryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AgendaEntryServiceImpl implements AgendaEntryService {

    private AgendaEntryRepository agendaEntryRepository;
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AgendaEntryServiceImpl(AgendaEntryRepository agendaEntryRepository, EventRepository eventRepository, ModelMapper modelMapper) {
        this.agendaEntryRepository = agendaEntryRepository;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AgendaEntryDTO> getAllAgendaEntriesByEventCodeOrderByPosition(String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<AgendaEntryDTO>>() {}.getType();
        List<AgendaEntryDTO> agendaEntryDTOS = modelMapper.map(agendaEntryRepository.findAllByEvent_CodeOrderByEntryPosition(eventCode), targetListType);
        return agendaEntryDTOS;
    }

    @Override
    public AgendaEntryDTO addAgendaEntryToEvent(AgendaEntryDTO agendaEntryDTO, String eventCode) {
        Event event = eventRepository.findFirstByCode(eventCode);
        agendaEntryDTO.setEvent(event);
        AgendaEntry agendaEntryEntity = modelMapper.map(agendaEntryDTO, AgendaEntry.class);
        agendaEntryRepository.save(agendaEntryEntity);
        return agendaEntryDTO;
    }

    @Override
    public void deleteAgendaEntryById(Long id) {
        agendaEntryRepository.deleteById(id);
    }

    @Override
    public Integer deleteAllAgendaEntriesByEventCode(String eventCode) {
        return agendaEntryRepository.deleteAllByEvent_Code(eventCode);
    }
}
