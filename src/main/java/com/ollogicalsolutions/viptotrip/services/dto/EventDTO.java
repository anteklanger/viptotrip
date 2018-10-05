package com.ollogicalsolutions.viptotrip.services.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EventDTO {

    private Long id;

    @NotNull
    @Size(min = 6, max = 6, message = "KOD MUSI BYC 6 ZNAKOWY I UNIKALNY")
    private String code;
    @NotNull
    private String eventCategory;
    @NotBlank(message = "POLE DATA NIE MOŻE BYC PUSTE")
    private String eventDate;
    @NotBlank(message = "POLE NAZWA IMPREZY NIE MOŻE BYC PUSTE")
    private String eventName;
    @NotBlank(message = "POLE MIEJSCE IMPREZY NIE MOŻE BYC PUSTE")
    private String hotelName;
    @NotBlank(message = "POLE ADRES IMPREZY NIE MOŻE BYC PUSTE")
    private String hotelAddress;
    @NotBlank(message = "POLE OPIS NIE MOŻE BYC PUSTE")
    private String hotelDescription;
    @NotNull(message = "POLE SZEROKOŚC GEOGRAFICZNA NIE MOŻE BYC PUSTE")
    private Long hotelLatitude;
    @NotNull(message = "POLE DŁUGOŚC GEOGRAFICZNA NIE MOŻE BYC PUSTE")
    private Long hotelLongitude;

}
