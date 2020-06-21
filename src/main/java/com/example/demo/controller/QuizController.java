package com.example.demo.controller;

import com.example.demo.dto.QuizDeleteDto;
import com.example.demo.dto.QuizDto;
import com.example.demo.entity.QuizEntity;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping(value = "/quiz/create", method = RequestMethod.POST)
    public void create(@RequestBody QuizDto quizDto) {
        quizService.create(quizDto);
    }

    @RequestMapping(value = "/quiz/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody QuizDeleteDto quizDeleteDto) {
        quizService.delete(quizDeleteDto.getNameQuiz());
    }

    @RequestMapping(value = "/quiz/Update", method = RequestMethod.POST)
    public void Update(@RequestBody QuizDto quizDto) {
        quizService.update(quizDto);
    }

    @RequestMapping(value = "/quiz/read", method = RequestMethod.POST)
    public List<QuizEntity> Delete() {
        return quizService.readAll();
    }

}
