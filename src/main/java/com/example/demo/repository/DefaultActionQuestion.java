package com.example.demo.repository;

import com.example.demo.dto.QuestionDto;
import com.example.demo.entity.QuestionEntity;

import java.util.List;

public interface DefaultActionQuestion {

    void create(QuestionDto questionDto);

    void delete(String nameQuiz, long position);

    void update(QuestionDto questionDto);

    List<QuestionEntity> readAll();

}
