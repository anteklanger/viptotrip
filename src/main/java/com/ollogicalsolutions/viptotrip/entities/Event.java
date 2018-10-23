package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "events", uniqueConstraints={@UniqueConstraint(columnNames={"event_code"})})
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_code", unique = true)
    @NotNull
    @Size(min = 6, max = 6, message = "KOD MUSI BYC 6 ZNAKOWY I UNIKALNY")
    private String code;

    @Column
    private String eventCategory;

    @Column
    private String eventDate;

    @Column
    private String eventName;

    @Column
    private String hotelName;

    @Column
    private String hotelAddress;

    @Column
    private String hotelDescription;

    @Column
    private Long hotelLatitude;

    @Column
    private Long hotelLongitude;

}
