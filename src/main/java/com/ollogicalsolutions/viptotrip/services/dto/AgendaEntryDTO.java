package com.ollogicalsolutions.viptotrip.services.dto;

import com.ollogicalsolutions.viptotrip.entities.Event;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AgendaEntryDTO {

    private Long id;

    @NotNull
    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    private Integer entryPosition;
    @NotBlank
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    private String startHour;
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    private String endHour;
    @NotBlank
    private String entryDescription;
    @NotBlank
    private String entryCategory;
    @NotNull
    private Event event;
}
