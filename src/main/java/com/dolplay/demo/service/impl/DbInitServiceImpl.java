package com.dolplay.demo.service.impl;

import com.dolplay.demo.domain.Role;
import com.dolplay.demo.domain.RoleRepository;
import com.dolplay.demo.domain.User;
import com.dolplay.demo.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by conanca on 17-2-16.
 */
@Service
public class DbInitServiceImpl {
    private static Logger logger = LoggerFactory.getLogger(DbInitServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void dbInit(){
        Role admin = new Role("ROLE_ADMIN");
        admin = roleRepository.save(admin);
        Role user = new Role("ROLE_USER");
        user = roleRepository.save(user);
        List<Role> roles = new ArrayList();
        roles.add(admin);

        // save a couple of users
        userRepository.save(new User("jack", passwordEncoder.encode("123"), roles));
        roles.add(user);
        userRepository.save(new User("john", passwordEncoder.encode("123"), roles));
        userRepository.save(new User("kate", passwordEncoder.encode("123"), roles));
        logger.info("database init.");
    }
}
