package com.ollogicalsolutions.viptotrip.services.dto;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MessageDTO {

    private Long id;
    @NotBlank
    private String body;
    @NotBlank
    private String created;
    private String category;
    @NotBlank
    private String authorCategory;
    @NotNull
    private User user;
    @NotNull
    private Event event;

}
