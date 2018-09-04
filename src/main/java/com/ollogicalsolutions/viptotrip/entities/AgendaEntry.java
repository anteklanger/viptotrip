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
    Integer entryPosition;
    @Column
    String startHour;
    @Column
    String endHour;
    @Column
    String entryDescription;
    @Column
    String entryCategory;

    @ManyToOne
    private Event event;


}
