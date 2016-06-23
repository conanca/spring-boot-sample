package com.xinhuanet.demo.domain;

import com.alibaba.fastjson.JSON;
import com.xinhuanet.demo.App;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by conanca on 16-6-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() throws Exception {
        // save a couple of users
        this.userRepository.save(new User("Jack", "123"));
        this.userRepository.save(new User("John", "123"));
        this.userRepository.save(new User("Kate", "123"));
    }

    @After
    public void after() throws Exception {
//        this.userRepository.deleteAll();
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
