package com.ollogicalsolutions.viptotrip.rest.api.rest_entities;

import lombok.Data;

@Data
public class FlightRestEntity {

    private String clientsFromCity;

    private String flightType;

    private String flightCode;

    private String departureAirport;

    private String departureTime;

    private String departureDate;

    private String arrivalAirport;

    private String arrivalTime;

    private String arrivalDate;
}
