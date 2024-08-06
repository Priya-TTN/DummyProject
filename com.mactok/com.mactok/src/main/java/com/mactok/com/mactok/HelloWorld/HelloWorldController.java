package com.mactok.com.mactok.HelloWorld;

//Rest API

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController

public class HelloWorldController {

    private MessageSource messageSource;
    public HelloWorldController(){}
   public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @GetMapping(path = "/hello")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    // path parameter
    // /user/{id}/todo/{id} --> /user/1/todo/101

    @GetMapping(path = "/hello-internaionalization")
    public String HelloWorldInternaionalization(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);

    }

    @PutMapping(path = "/hello-internaionalization")
    public HelloWorldBean HelloWorldInternaionalization(@PathVariable int id, @RequestBody HelloWorldBean HelloWorldBean){
        System.out.print("Updated");
        return HelloWorldBean;

    }

}
