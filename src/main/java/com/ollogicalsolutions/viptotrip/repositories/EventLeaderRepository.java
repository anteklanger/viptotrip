package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.EventLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventLeaderRepository extends JpaRepository<EventLeader, Long> {

    List<EventLeader> findAllByEvent_Code(String eventCode);
    Integer deleteAllByEvent_Code(String eventCode);
}
