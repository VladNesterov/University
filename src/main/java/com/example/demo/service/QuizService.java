package com.example.demo.service;

import com.example.demo.customExeptions.QuizNotFoundForChange;
import com.example.demo.customExeptions.QuizWasExist;
import com.example.demo.dto.QuizDto;
import com.example.demo.entity.QuizEntity;
import com.example.demo.repository.DefaultActionQuiz;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements DefaultActionQuiz {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void create(QuizDto quizDto) {
        QuizEntity quizEntityAlreadyExists = quizRepository.findByName(quizDto.getName());
        if (quizEntityAlreadyExists == null) {
            QuizEntity quizEntity = new QuizEntity();
            quizEntity.setName(quizDto.getName());
            quizEntity.setFinishDate(quizDto.getFinishDate());
            quizEntity.setStartDate(quizDto.getStartDate());
            quizEntity.setStatus(quizDto.getStatus());
            quizEntity.setStatus("Active");
            quizRepository.save(quizEntity);
        } else {
            throw new QuizWasExist("This quiz: " + quizDto.getName() + " was create");
        }
    }

    @Override

    public void delete(String name) {
        QuizEntity quizEntity = quizRepository.findByName(name);
        if (quizEntity == null) {
            throw new QuizNotFoundForChange("This quiz: " + name + " not found");
        }
        questionRepository.deleteAll(quizEntity.getQuestionEntities());
        quizRepository.delete(quizEntity);
    }

    @Override
    public void update(QuizDto quizDto) {
        QuizEntity quizEntity = quizRepository.findByName(quizDto.getName());
        if (quizEntity != null) {
            if (quizDto.getStatus() != null) quizEntity.setStatus(quizDto.getStatus());
            if (quizDto.getStartDate() != null) quizEntity.setStartDate(quizDto.getStartDate());
            if (quizDto.getFinishDate() != null) quizEntity.setFinishDate(quizDto.getFinishDate());

        } else {
            throw new QuizNotFoundForChange("This quiz: " + quizDto.getName() + " not found to update");
        }
        quizRepository.save(quizEntity);
    }

    @Override
    public List<QuizEntity> readAll() {
        return quizRepository.findAll();
    }

    @Override
    public void cancelQuiz(String name) {
        QuizEntity quizEntity = quizRepository.findByName(name);
        if (quizEntity == null) {
            throw new QuizNotFoundForChange("This quiz: " + name + " not found");
        }
        quizRepository.setInactive(name);
    }

}