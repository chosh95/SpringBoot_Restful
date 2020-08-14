package com.example.restful.controller;

import com.example.restful.domain.HelloBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MessageSource messageSource;

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

    @GetMapping("/hello-internationalized")
    public String helloInter(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting.message",null,locale);
    }
}
