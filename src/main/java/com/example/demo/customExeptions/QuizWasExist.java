package com.example.demo.customExeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuizWasExist extends RuntimeException {

    public QuizWasExist(String message) {
        super(message);
    }

}
