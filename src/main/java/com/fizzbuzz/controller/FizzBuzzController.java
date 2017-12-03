package com.fizzbuzz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fizzbuzz.model.FizzBuzz;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class FizzBuzzController {
    @RequestMapping(value = "/fizzbuzz/{upperLimit}", method = RequestMethod.GET, produces = "application/json")
    public String fizzBuzz(@PathVariable("upperLimit") int upperLimit, HttpServletResponse response) {
        Logger logger = Logger.getLogger(FizzBuzzController.class);

        FizzBuzz fizzBuzzObj = new FizzBuzz();
        List<Integer> fizzList = new ArrayList<>(),
                      buzzList = new ArrayList<>(), 
                      fizzBuzzList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Loop through range of numbers, adding them to their corresponding list.
            IntStream.range(1, upperLimit + 1)
            .forEach(i -> {
                switch (CategorizerChain.Calculate(i)) {
                    case "Buzz":
                        buzzList.add(i);
                        break;
                    case "Fizz":
                        fizzList.add(i);
                        break;
                    case "FizzBuzz":
                        fizzBuzzList.add(i);
                        break;
                }
            });

            fizzBuzzObj.setFizz(fizzList);
            fizzBuzzObj.setBuzz(buzzList);
            fizzBuzzObj.setFizzBuzz(fizzBuzzList);

            return objectMapper.writeValueAsString(fizzBuzzObj);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    // Return this error if a non-integer value is supplied for upperLimit.
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void handleParameterTypeMismatch(IllegalArgumentException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again with an integer value.");
    }

    // Return this error if there is an issue serializing JSON.
    @ExceptionHandler(JsonProcessingException.class)
    public void handleSerializationError(JsonProcessingException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "There was an error serializing an object to JSON.");
    }
}