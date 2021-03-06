package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role")
    private String name;

}
