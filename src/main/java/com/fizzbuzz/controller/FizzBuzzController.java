package com.fizzbuzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fizzbuzz.model.FizzBuzz;
import com.fizzbuzz.controller.CategorizerChain;

import java.util.*;
import java.io.*;

@RestController
public class FizzBuzzController {
    @RequestMapping(value = "/fizzbuzz/{upperLimit}", method = RequestMethod.GET, produces = "application/json")
    public String fizzBuzz(@PathVariable("upperLimit") int upperLimit) {
        List<String> results = new ArrayList<>();

        for(int i = 1; i <= upperLimit; i++) {
            results.add(CategorizerChain.Calculate(i));
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);

            FizzBuzz fb = new FizzBuzz();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();

            a.add(1);
            b.add(2);
            c.add(3);

            fb.setFizz(a);
            fb.setBuzz(b);
            fb.setFizzBuzz(c);

            return objectMapper.writeValueAsString(fb);
        } catch(Exception e) {
            // return e.toString(); // Remove this, this is for debugging
            return null;
        }
    }
}