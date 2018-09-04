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
    String clientsFromCity;

    @Column
    String flightType;
    @Column
    String flightCode;
    @Column
    String departureAirport;
    @Column
    String departureTime;
    @Column
    String departureDate;
    @Column
    String arrivalAirport;
    @Column
    String arrivalTime;
    @Column
    String arrivalDate;

    @ManyToOne
    private Event event;

}