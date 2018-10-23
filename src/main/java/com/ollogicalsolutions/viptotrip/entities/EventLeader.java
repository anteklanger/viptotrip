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
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String city;
    @Column
    private String role;

    @ManyToOne
    private Event event;
}
