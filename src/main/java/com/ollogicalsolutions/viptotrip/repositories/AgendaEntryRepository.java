package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.AgendaEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AgendaEntryRepository extends JpaRepository<AgendaEntry, Long> {
    List<AgendaEntry> findAllByEvent_CodeOrderByEntryPosition(String eventCode);
}
