package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String created;
    private String category;
    private String authorCategory;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
}
