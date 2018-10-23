package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;

import java.util.List;

public interface EventLeaderService {
    List<EventLeaderDTO> getEventLeadersByEventCode(final String eventCode);
    EventLeader addEventLeaderToEvent(final EventLeaderDTO eventLeaderDTO, final String eventCode);
    void deleteEventLeaderById(final Long id);
    Integer deleteAllEventLeadersByEventCode(final String eventCode);
}
