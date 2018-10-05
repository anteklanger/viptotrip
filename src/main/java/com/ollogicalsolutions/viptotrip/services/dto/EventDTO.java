package com.ollogicalsolutions.viptotrip.services.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EventDTO {

    private Long id;

    @NotNull
    @Size(min = 6, max = 6, message = "KOD MUSI BYC 6 ZNAKOWY I UNIKALNY")
    private String code;

    private String eventCategory;

    private String eventDate;

    private String eventName;

    private String hotelName;

    private String hotelAddress;

    private String hotelDescription;

    private Long hotelLatitude;

    private Long hotelLongitude;

}
