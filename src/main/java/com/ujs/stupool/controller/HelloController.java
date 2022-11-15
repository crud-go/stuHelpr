package com.ujs.stupool.controller;

import com.ujs.stupool.model.Hello;
import com.ujs.stupool.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {

        this.helloService = helloService;
    }

    @GetMapping("/hi")
    Hello sayHello(){

        return helloService.getHello();
    }


}
