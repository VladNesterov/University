package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuizDto {

    String name;
    Date startDate;
    Date finishDate;
    String status;

}
