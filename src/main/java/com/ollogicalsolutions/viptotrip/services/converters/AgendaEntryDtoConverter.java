package com.ollogicalsolutions.viptotrip.services.converters;

import com.ollogicalsolutions.viptotrip.services.dto.AgendaEntryDTO;
import org.springframework.core.convert.converter.Converter;

public class AgendaEntryDtoConverter implements Converter <String, AgendaEntryDTO> {
    @Override
    public AgendaEntryDTO convert(final String s) {
        final AgendaEntryDTO agendaEntryDTO = new AgendaEntryDTO();
        agendaEntryDTO.setId(Long.parseLong(s));
        return agendaEntryDTO;
    }
}

