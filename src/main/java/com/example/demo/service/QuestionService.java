package com.example.demo.service;

import com.example.demo.customExeptions.QuizNotFoundForChange;
import com.example.demo.dto.QuestionDto;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.entity.QuizEntity;
import com.example.demo.repository.DefaultActionQuestion;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements DefaultActionQuestion {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void create(QuestionDto questionDto) {

        QuizEntity quizEntity = quizRepository.findByName(questionDto.getNameQuiz());
        if (quizEntity != null) {
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setLink(quizEntity.getId());
            questionEntity.setOrder(questionDto.getOrder());
            questionEntity.setText(questionDto.getText());

            List<QuestionEntity> quizEntityList = quizEntity.getQuestionEntities();
            quizEntityList.add(questionEntity);
            quizEntity.setQuestionEntities(quizEntityList);

            questionRepository.save(questionEntity);
            quizRepository.save(quizEntity);
        } else {
            throw new QuizNotFoundForChange("Need to create quiz before add question");
        }
    }

    @Override
    public void delete(String nameQuiz, long position) {
        QuizEntity quizEntity = quizRepository.findByName(nameQuiz);
        QuestionEntity questionEntity = new QuestionEntity();
        if (quizEntity != null && quizEntity.getQuestionEntities() != null) {
            for (int i = 0; i < quizEntity.getQuestionEntities().size(); i++) {
                if (quizEntity.getQuestionEntities().get(i).getOrder() == position) {
                    quizEntity.getQuestionEntities().remove(i);
//                    questionEntity = quizEntity.getQuestionEntities().get(i);
                    break;
                }
            }

        } else {
            throw new QuizNotFoundForChange("This quiz not found for change");
        }

        quizRepository.save(quizEntity);
    }

    @Override
    public void update(QuestionDto questionDto) {
        QuizEntity quizEntity = quizRepository.findByName(questionDto.getNameQuiz());
        if (quizEntity != null) {
            QuestionEntity questionEntity = new QuestionEntity();
            List<QuestionEntity> quizEntityList = quizEntity.getQuestionEntities();

            for (int i = 0; i < quizEntityList.size(); i++) {
                if (quizEntity.getQuestionEntities().get(i).getOrder() == questionDto.getOrder()) {
                    questionEntity = quizEntity.getQuestionEntities().get(i);
                    questionEntity.setOrder(questionDto.getOrder());
                    questionEntity.setText(questionDto.getText());
                    break;
                }
            }
            questionRepository.save(questionEntity);
        } else {
            throw new QuizNotFoundForChange("This quiz not found for change");
        }
    }

    @Override
    public List<QuestionEntity> readAll() {
        return questionRepository.findAll();
    }
}
