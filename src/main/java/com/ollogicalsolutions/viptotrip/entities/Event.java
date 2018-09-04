package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
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


//    @OneToMany
//    @JoinColumn
//    private List<Message> messages;

//    @OneToMany
//    @JoinColumn
//    private List<User> users;

}
