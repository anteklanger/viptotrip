package com.ollogicalsolutions.viptotrip.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "agendaentries")
@Data
public class AgendaEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer entryPosition;
    @Column
    private String startHour;
    @Column
    private String endHour;
    @Column
    private String entryDescription;
    @Column
    private String entryCategory;

    @ManyToOne
    private Event event;


}
