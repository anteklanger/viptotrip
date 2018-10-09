package com.ollogicalsolutions.viptotrip.services.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightDTO {

    private Long id;

    @NotBlank
    String clientsFromCity;
    @NotBlank
    String flightType;
    @NotBlank
    String flightCode;
    @NotBlank
    String departureAirport;
    @NotBlank(message = "FORMAT hh/mm")
    @DateTimeFormat(pattern = "hh/mm")
    String departureTime;
    @NotBlank(message = "FORMAT dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    String departureDate;
    @NotBlank
    String arrivalAirport;
    @NotBlank(message = "FORMAT hh/mm")
    @DateTimeFormat(pattern = "hh/mm")
    String arrivalTime;
    @NotBlank(message = "FORMAT dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    String arrivalDate;

}
