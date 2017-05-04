package com.dolplay.demo.web;

import com.dolplay.demo.service.HelloService;
import com.dolplay.demo.service.impl.DbInitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

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
    public String index(HttpSession session) {

        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        logger.info("Current user is :"+uid);
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
