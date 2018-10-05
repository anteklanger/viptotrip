package com.ollogicalsolutions.viptotrip.services.dto;

import lombok.Data;

@Data
public class EventDTO {

    private Long id;

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
