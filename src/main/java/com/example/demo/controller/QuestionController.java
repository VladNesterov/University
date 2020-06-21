package com.example.demo.controller;

import com.example.demo.dto.QuestionDeleteDto;
import com.example.demo.dto.QuestionDto;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/question/create", method = RequestMethod.POST)
    public void create(@RequestBody QuestionDto questionDto) {
        questionService.create(questionDto);
    }

    @RequestMapping(value = "/question/read", method = RequestMethod.POST)
    public List<QuestionEntity> read() {
        return questionService.readAll();
    }

    @RequestMapping(value = "/question/update", method = RequestMethod.POST)
    public void update(@RequestBody QuestionDto questionDto) {
        questionService.update(questionDto);
    }

    @RequestMapping(value = "/question/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody QuestionDeleteDto questionDeleteDto) {
        questionService.delete(questionDeleteDto.getNameQuiz(), questionDeleteDto.getPosition());
    }
}
