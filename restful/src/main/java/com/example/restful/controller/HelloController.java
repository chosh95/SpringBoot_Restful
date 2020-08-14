package com.example.restful.controller;

import com.example.restful.domain.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello-bean")
    public HelloBean helloBean(){
        return new HelloBean("Hello World");
    }

    @GetMapping("/hello-bean/{name}")
    public HelloBean helloBean(@PathVariable("name") String name){
        return new HelloBean(name);
    }
}
