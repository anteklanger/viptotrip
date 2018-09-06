package com.ollogicalsolutions.viptotrip.repositories;

import com.ollogicalsolutions.viptotrip.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role_user);
}
