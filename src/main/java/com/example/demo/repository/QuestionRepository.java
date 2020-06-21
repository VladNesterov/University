package com.example.demo.repository;

import com.example.demo.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    @Query("SELECT qe FROM QuestionEntity qe WHERE qe.link = :link")
    List<QuestionEntity> findAllQuizByLinkOnQuiz(Long link);

}
