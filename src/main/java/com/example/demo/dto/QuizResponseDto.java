package com.example.demo.dto;

import com.example.demo.entity.QuestionEntity;
import com.example.demo.entity.QuizEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuizResponseDto {

    String name;
    Date startDate;
    Date finishDate;
    String status;
    List<QuestionEntity> questionEntityList;

    public QuizResponseDto toQuizResponseDto(QuizEntity quizEntity) {
        QuizResponseDto quizResponseDto = new QuizResponseDto();
        quizResponseDto.setName(quizEntity.getName());
        quizResponseDto.setFinishDate(quizEntity.getFinishDate());
        quizResponseDto.setStartDate(quizEntity.getStartDate());
        quizResponseDto.setStatus(quizEntity.getStatus());
        quizResponseDto.setQuestionEntityList(quizEntity.getQuestionEntities());
        return quizResponseDto;
    }

}
