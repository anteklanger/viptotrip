package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByUserAndEventAndAuthorCategoryOrderByCreated(String user, String event, String authorCategory);

    List<Message> findAllByEventAndAuthorCategoryOrderByCreated(String eventCode, String authorCategory);

    List<Message> findAllByEvent_Code(String eventCode);

}
