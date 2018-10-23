package com.ollogicalsolutions.viptotrip.services.converters;

import com.ollogicalsolutions.viptotrip.services.dto.EventLeaderDTO;
import org.springframework.core.convert.converter.Converter;

public class EventLeaderDtoConverter implements Converter<String, EventLeaderDTO> {
    @Override
    public EventLeaderDTO convert(final String s) {
        final EventLeaderDTO eventLeaderDTO = new EventLeaderDTO();
        eventLeaderDTO.setId(Long.parseLong(s));
        return eventLeaderDTO;
    }
}
