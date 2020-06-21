package com.example.demo.customExeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuizNotFoundForChange extends RuntimeException {

    public QuizNotFoundForChange(String message) {
        super(message);
    }

}
