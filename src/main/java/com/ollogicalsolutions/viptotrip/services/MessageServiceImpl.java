package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.Message;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.MessageRepository;
import com.ollogicalsolutions.viptotrip.services.dto.MessageDTO;
import com.ollogicalsolutions.viptotrip.services.interfaces.MessageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, EventRepository eventRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MessageDTO> getAllMessagesByEventCode(String eventCode) {
        java.lang.reflect.Type targetListType = new TypeToken<List<MessageDTO>>() {
        }.getType();
        List<MessageDTO> messageDTOS = modelMapper.map(messageRepository.findAllByEvent_Code(eventCode), targetListType);
        return messageDTOS;
    }

    @Override
    public MessageDTO addMessageToEvent(MessageDTO messageDTO, String eventCode) {
        Event event = eventRepository.findFirstByCode(eventCode);
        Message messageEntity = modelMapper.map(messageDTO, Message.class);
        messageEntity.setEvent(event);
        messageRepository.save(messageEntity);
        return messageDTO;
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);

    }

    @Override
    public Integer deleteAllMessagesByEventCode(String eventCode) {

        return messageRepository.deleteAllByEvent_Code(eventCode);
    }
}

