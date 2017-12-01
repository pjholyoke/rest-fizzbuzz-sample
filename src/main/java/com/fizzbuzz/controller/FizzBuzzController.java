package com.fizzbuzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fizzbuzz.controller.CategorizerChain;

import java.util.*;
import java.io.*;

@RestController
public class FizzBuzzController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld() {
        List<String> results = new ArrayList<>();

        for(int i = 1; i <= 100; i++) {
            results.add(CategorizerChain.Calculate(i));
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);
        } catch(Exception e) {
            return e.toString(); // Remove this, this is for debugging
        }
    }
}