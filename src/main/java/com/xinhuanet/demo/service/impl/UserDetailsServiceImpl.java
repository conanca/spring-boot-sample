package com.xinhuanet.demo.service.impl;

import com.xinhuanet.demo.domain.Role;
import com.xinhuanet.demo.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by conanca on 16-6-17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("loading user...");
        // get user
        List<com.xinhuanet.demo.domain.User> users = userRepository.findByName(username);
        if (users.size() == 0) {
            throw new UsernameNotFoundException("User details not found with this username: " + username);
        }
        com.xinhuanet.demo.domain.User user = users.get(0);
        String password = user.getPassword();
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authList = getAuthorities(roles);

        User userDetails = new User(username, password, authList);
        return userDetails;
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> authList = new ArrayList();

        for (Role role : roles) {
            if (role != null && role.getName().trim().length() > 0) {
                authList.add(new SimpleGrantedAuthority(role.getName().trim()));
            }
        }

        return authList;
    }
}
