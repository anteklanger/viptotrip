package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.services.dto.FlightDTO;
import java.util.List;

public interface FlightService {

    List<FlightDTO> getFlightsByEventCode(final String eventCode);
    FlightDTO createFlight(final FlightDTO flightDTO, final String eventCode);
}
