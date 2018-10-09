package com.ollogicalsolutions.viptotrip.services.interfaces;

import com.ollogicalsolutions.viptotrip.entities.User;

import java.util.List;


public interface UserService {
    User findByUserName(String name);
    void saveUser(User user, List<String> role);
}