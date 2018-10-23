package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import com.ollogicalsolutions.viptotrip.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getMessagesByEventCode(final String eventCode);
    MessageDTO addMessageToEvent(final EventLeaderDTO eventLeaderDTO, final String eventCode);
    void deleteMessageById(final Long id);
    Integer deleteAllMessagesByEventCode(final String eventCode);
}
