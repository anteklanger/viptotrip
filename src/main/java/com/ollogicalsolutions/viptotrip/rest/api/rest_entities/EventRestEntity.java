package com.ollogicalsolutions.viptotrip.rest.api.rest_entities;

import lombok.Data;

@Data
public class EventRestEntity {

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
