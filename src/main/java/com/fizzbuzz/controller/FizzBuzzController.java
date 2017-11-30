package com.fizzbuzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
    public String helloWorld() {
        return "Hello World";
    }
}