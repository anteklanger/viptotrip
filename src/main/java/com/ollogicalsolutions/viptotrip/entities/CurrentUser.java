package com.ollogicalsolutions.viptotrip.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private User user;

    public CurrentUser(String username, String password, Collection<?
            extends GrantedAuthority> authorities, User user) {
        super(username, password, authorities);
        this.user = user;

    }
    public User getUser() {
        return user;
    }
}
