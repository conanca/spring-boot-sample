package com.xinhuanet.demo.service.impl;

import com.xinhuanet.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by conanca on 15-5-28.
 */
@Service
public class HelloServiceImpl implements HelloService {

    public void say() {
        System.out.println("Hello world!");
    }
}
