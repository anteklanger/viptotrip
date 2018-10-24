package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import com.ollogicalsolutions.viptotrip.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getAllMessagesByEventCode(final String eventCode);
    MessageDTO addMessageToEvent(final MessageDTO messageDTO, final String eventCode);
    void deleteMessageById(final Long id);
    Integer deleteAllMessagesByEventCode(final String eventCode);
}
