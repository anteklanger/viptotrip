package com.ollogicalsolutions.viptotrip.services.converters;

import com.ollogicalsolutions.viptotrip.services.dto.MessageDTO;
import org.springframework.core.convert.converter.Converter;

public class MessageDtoConverter implements Converter<String, MessageDTO> {
    @Override
    public MessageDTO convert(final String s) {
        final MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(Long.parseLong(s));
        return messageDTO;
    }
}
