package com.ollogicalsolutions.viptotrip.services.converters;

import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import org.springframework.core.convert.converter.Converter;

public class EventDtoConverter implements Converter<String, EventDTO> {
    @Override
    public EventDTO convert(final String s) {
        final EventDTO eventDTO = new EventDTO();
        eventDTO.setId(Long.parseLong(s));
        return eventDTO;
    }
}
