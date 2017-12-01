package com.fizzbuzz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = false)
public class FizzBuzz {
    @JsonProperty("Fizz")
    private List<Integer> Fizz;

    @JsonProperty("Buzz")
    private List<Integer> Buzz;

    @JsonProperty("FizzBuzz")
    private List<Integer> FizzBuzz;

    public List<Integer> getFizz() {
        return Fizz;
    }

    public void setFizz(List<Integer> fizz) {
        Fizz = fizz;
    }

    public List<Integer> getBuzz() {
        return Buzz;
    }

    public void setBuzz(List<Integer> buzz) {
        Buzz = buzz;
    }

    public List<Integer> getFizzBuzz() {
        return FizzBuzz;
    }

    public void setFizzBuzz(List<Integer> fizzBuzz) {
        FizzBuzz = fizzBuzz;
    }
}