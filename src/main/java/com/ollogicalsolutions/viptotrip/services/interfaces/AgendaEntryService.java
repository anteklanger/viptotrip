package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.entities.AgendaEntry;
import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import com.ollogicalsolutions.viptotrip.services.dto.AgendaEntryDTO;
import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;

import java.util.List;

public interface AgendaEntryService {

    List<AgendaEntryDTO> getAllAgendaEntriesByEventCodeOrderByPosition(final String eventCode);
    AgendaEntryDTO addAgendaEntryToEvent(final AgendaEntryDTO agendaEntryDTO, final String eventCode);
    void deleteAgendaEntryById(final Long id);
    Integer deleteAllAgendaEntriesByEventCode(final String eventCode);
}
