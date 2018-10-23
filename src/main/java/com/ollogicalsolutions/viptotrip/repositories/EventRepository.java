package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<User> findAllByCode(String code);
    Event findFirstByCode(String code);
    Integer removeEventByCode(String code);

}
