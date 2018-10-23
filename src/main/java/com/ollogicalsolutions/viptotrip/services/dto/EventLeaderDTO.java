package com.ollogicalsolutions.viptotrip.services.dto;

import com.ollogicalsolutions.viptotrip.entities.Event;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EventLeaderDTO {

    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;

    private String phone;

    private String city;

    private String role;

    private Event event;

}
