package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false)
    private Boolean guestVip;

    @Column(nullable = false)
    private Boolean editorVip;

    @Column(nullable = false)
    private Boolean adminVip;

//    @OneToMany
//    @JoinColumn
//    private List<UsersMessage> usersMessages;
//
    @ManyToOne
//    @JoinColumn
    private Event event;

}
