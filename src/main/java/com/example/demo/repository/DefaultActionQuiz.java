package com.example.demo.repository;

import com.example.demo.dto.QuestionDto;
import com.example.demo.dto.QuizDto;
import com.example.demo.dto.QuizResponseDto;
import com.example.demo.entity.QuizEntity;
import javassist.NotFoundException;

import java.util.List;

public interface DefaultActionQuiz {

    void create(QuizDto quizDto);

    void delete(String name);

    void update(QuizDto quizDto);

    List<QuizEntity> readAll();

    void cancelQuiz(String name);
}
