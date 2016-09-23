package com.xinhuanet.demo.domain;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by conanca on 16-6-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static boolean initialized = false;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void before() throws Exception {
        if (!initialized) {
            Role admin = new Role("ROLE_ADMIN");
            admin = roleRepository.save(admin);
            Role user = new Role("ROLE_USER");
            user = roleRepository.save(user);
            List<Role> roles = new ArrayList<>();
            roles.add(admin);

            // save a couple of users
            userRepository.save(new User("jack", passwordEncoder.encode("123"), roles));
            roles.add(user);
            userRepository.save(new User("john", passwordEncoder.encode("123"), roles));
            userRepository.save(new User("kate", passwordEncoder.encode("123"), roles));
            initialized=true;
        }
    }

    @After
    public void after() throws Exception {
//        userRepository.deleteAll();
//        roleRepository.deleteAll();
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> users = userRepository.findByName("Jack");
        System.out.println();
        System.out.println(JSON.toJSON(users));
        System.out.println();
    }

    @Test
    public void testFindAll() throws Exception {
        Pageable page = new PageRequest(0,
                10,
                new Sort(Sort.Direction.DESC, "name")
                        .and(new Sort(Sort.Direction.ASC, "password")));

        Page usersPage = userRepository.findAll(page);
        List<User> users = usersPage.getContent();
        System.out.println();
        System.out.println(JSON.toJSON(users));
        System.out.println();
    }
}
