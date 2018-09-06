package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String pin;

    @Column
    private String password;

    @Column
    private Boolean guestVip;

    @Column
    private Boolean editorVip;

    @Column
    private Boolean adminVip;

    @Column
//    private Boolean enabled;

    private Boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    //    @OneToMany
//    @JoinColumn
//    private List<UsersMessage> usersMessages;
//
    @ManyToOne
//    @JoinColumn
    private Event event;

}
