package com.fizzbuzz.controller;

import java.lang.String;

import com.fizzbuzz.controller.Categorizer;
import com.fizzbuzz.controller.FizzCategorizer;
import com.fizzbuzz.controller.BuzzCategorizer;
import com.fizzbuzz.controller.FizzBuzzCategorizer;

public class CategorizerChain {
    private CategorizerChain() {
        Head = new FizzBuzzCategorizer();
        Head.registerNextRule(new BuzzCategorizer())
                .registerNextRule(new FizzCategorizer())
                .registerNextRule(new FizzBuzzCategorizer())
                .registerNextRule(new DefaultCategorizer());
    }

    private Categorizer Head;

    public Categorizer getHead() {
        return Head;
    }

    public void setHead(Categorizer head) {
        Head = head;
    }

    public static String Calculate(int number) {
        return _instance.Head.checkRule(number);
    }

    private static final CategorizerChain _instance = new CategorizerChain();
}