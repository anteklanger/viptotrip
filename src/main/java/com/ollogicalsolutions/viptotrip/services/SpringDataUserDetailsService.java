package com.ollogicalsolutions.viptotrip.services;//package com.ollogicalsolutions.viptotrip.services;
//
//import com.ollogicalsolutions.viptotrip.entities.Role;
//import com.ollogicalsolutions.viptotrip.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class SpringDataUserDetailsService implements UserDetailsService{
//
//    private UserService userService;
//    @Autowired
//    public void setUserRepository(UserService userService) { this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByUserName(username);
//        if (user == null) {throw new UsernameNotFoundException(username); } Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())); }
//        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), grantedAuthorities);
//    }
//}


import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.RoleRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl service;

//    @Autowired
//    private MessageSource messages;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        List<GrantedAuthority> authorityList = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        for (GrantedAuthority a: authorityList
             ) {
            System.out.println(a.getAuthority());
        }

//        if (user == null) {
//            return new org.springframework.security.core.userdetails.User(
//                    " ", " ", true, true, true, true,
//                    getAuthorities(Arrays.asList(
//                            roleRepository.findByName("ROLE_USER"))));
//        }


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getEnabled(), true, true,
                true, authorityList);
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(
//            Collection<Role> roles) {
//
//        return getGrantedAuthorities(getPrivileges(roles));
//    }


//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }


//    @Autowired
//    private UserRepository usersService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = usersService.findByUsername(username);
//        if (user != null) {
//            List<GrantedAuthority> authorityList = user.getRoles().stream()
//                    .map(role -> new SimpleGrantedAuthority(role.getName()))
//                    .collect(Collectors.toList());
//
//            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(), true, true, true, authorityList);
//        }
//
//        return null;
//    }

//    public UserDetails loadUserByUsername(String username) {
//        User user = usersService.findByUsername(username);
//        if (user == null) {throw new UsernameNotFoundException(username); } Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())); }
//        return new CurrentUser(user.getUsername(),user.getPassword(), grantedAuthorities, user);
//    }
}