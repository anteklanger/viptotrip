package com.ollogicalsolutions.viptotrip.services.dto;

import com.ollogicalsolutions.viptotrip.entities.Event;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FlightDTO {

    private Long id;

    @NotBlank
    private String clientsFromCity;
    @NotBlank
    private String flightType;
    @NotBlank
    private String flightCode;
    @NotBlank
    private String departureAirport;
    @NotBlank(message = "FORMAT hh/mm")
    @DateTimeFormat(pattern = "hh/mm")
    private String departureTime;
    @NotBlank(message = "FORMAT dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String departureDate;
    @NotBlank
    private String arrivalAirport;
    @NotBlank(message = "FORMAT hh/mm")
    @DateTimeFormat(pattern = "hh/mm")
    private String arrivalTime;
    @NotBlank(message = "FORMAT dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String arrivalDate;
    @NotNull
    private Event event;

}
