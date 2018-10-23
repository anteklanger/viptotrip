package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByEvent_Code(String eventCode);
    void deleteAllByEvent_Code(String eventCode);
}
