package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "eventleadres")
@Data
public class EventLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    String name;
    @Column
    String email;
    @Column
    String phone;
    @Column
    String city;
    @Column
    String role;

    @ManyToOne
    private Event event;
}
