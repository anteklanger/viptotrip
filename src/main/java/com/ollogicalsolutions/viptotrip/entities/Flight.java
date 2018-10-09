package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "flights")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String clientsFromCity;

    @Column
    private String flightType;
    @Column
    private String flightCode;
    @Column
    private String departureAirport;
    @Column
    private String departureTime;
    @Column
    private String departureDate;
    @Column
    private String arrivalAirport;
    @Column
    private String arrivalTime;
    @Column
    private String arrivalDate;

    @ManyToOne
    private Event event;

}