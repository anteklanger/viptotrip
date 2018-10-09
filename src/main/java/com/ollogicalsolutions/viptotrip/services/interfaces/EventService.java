package com.ollogicalsolutions.viptotrip.services.interfaces;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;

public interface EventService {

    EventDTO createEvent(final EventDTO eventDTO);
    EventDTO saveEditedEvent(final EventDTO eventDTO);
    EventDTO getEventByCode(final String eventCode);

}
