package com.xinhuanet.demo.service.impl;

import com.xinhuanet.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Created by conanca on 15-5-28.
 */
@Service
public class HelloServiceImpl implements HelloService {
    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @PreAuthorize("hasRole('USER')")
    public void say() {
        logger.info("say...");
        System.out.println("Hello world!");
    }
}
