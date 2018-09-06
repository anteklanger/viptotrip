package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsernameAllIgnoreCase(String username);
    List<User> findAllByEvent_Code(String eventCode);
    List<User> findAllByEditorVip(Boolean editor);
    List<User> findAllByAdminVip(Boolean admin);
    User findByUsername(String username);

}
