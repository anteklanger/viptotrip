package com.ollogicalsolutions.viptotrip.services.converters;

import com.ollogicalsolutions.viptotrip.services.dto.FlightDTO;
import org.springframework.core.convert.converter.Converter;


public class FlightDtoConverter implements Converter<String, FlightDTO> {
    @Override
    public FlightDTO convert(final String s) {
        final FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(Long.parseLong(s));
        return flightDTO;
    }
}
