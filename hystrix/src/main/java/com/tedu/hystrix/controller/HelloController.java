package com.tedu.hystrix.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tedu.hystrix.service.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloFeign helloFeign;
    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(@PathVariable String name){
        return helloFeign.hello(name);
    }

    public String helloFallback(String name){
        return "tony";

    }
}
