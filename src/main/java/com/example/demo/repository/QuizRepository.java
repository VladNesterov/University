package com.example.demo.repository;

import com.example.demo.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

    @Query("SELECT qe FROM QuizEntity qe WHERE qe.name = :name")
    QuizEntity findByName(String name);

    @Modifying
    @Query(" UPDATE QuizEntity qe SET qe.status ='Inactive' WHERE qe.name = :name")
    void setInactive(String name);

    @Modifying
    @Query(" UPDATE QuizEntity qe SET qe.status ='Active' WHERE qe.name = :name")
    void setActive(String name);

    @Modifying
    @Query(" DELETE from QuizEntity qe where qe.name =:name")
    void deleteByName(String name);

}
