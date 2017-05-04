package com.dolplay.demo.service.impl;

import com.dolplay.demo.service.HelloService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * HelloServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 30, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloServiceImplTest {

    @Autowired
    private HelloService helloServiceImpl;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: say()
     */
    @Test
    public void testSay() throws Exception {
        helloServiceImpl.say();
    }


} 
