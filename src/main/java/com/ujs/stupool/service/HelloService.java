package com.ujs.stupool.service;

import com.ujs.stupool.mapper.HelloMapper;
import com.ujs.stupool.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    HelloMapper helloMapper;

    @Autowired
    public HelloService(HelloMapper helloMapper) {
        this.helloMapper = helloMapper;
    }

   public Hello getHello(){
        return helloMapper.getHello();
    }


}
