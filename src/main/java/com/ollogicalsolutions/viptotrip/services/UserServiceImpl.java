package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Role;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.RoleRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user, List<String> roles) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        List<Role> userRolesList = new ArrayList<>();
        Role userRole;
        for (String r : roles
        ) {
            userRole = roleRepository.findByName("ROLE_"+r);
            userRolesList.add(userRole);
        }
        user.setRoles(new HashSet<>(userRolesList));

        userRepository.save(user);
    }
}
