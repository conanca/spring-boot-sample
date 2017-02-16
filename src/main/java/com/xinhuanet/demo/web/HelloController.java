package com.xinhuanet.demo.web;

import com.xinhuanet.demo.service.HelloService;
import com.xinhuanet.demo.service.impl.DbInitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private DbInitServiceImpl dbInitService;

    @RequestMapping("/dbInit")
    public String dbInit() {
        dbInitService.dbInit();
        return "index";
    }

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        helloService.say();
        return "Hello World!";
    }

    @RequestMapping("/call")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String call() {
        return "calling!";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
