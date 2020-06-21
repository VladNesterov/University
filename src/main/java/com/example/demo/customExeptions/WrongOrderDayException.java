package com.example.demo.customExeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongOrderDayException extends RuntimeException {

    public WrongOrderDayException(String message) {
        super(message);
    }

}
