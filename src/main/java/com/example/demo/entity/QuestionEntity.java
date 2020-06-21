package com.example.demo.entity;

import com.example.demo.dto.QuestionDto;
import jdk.internal.jline.internal.Nullable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class QuestionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @Nullable
    private long id;

    @Column(name = "link_quiz")
    private long link;

    @Column(name = "text_question")
    private String text;

    @Column(name = "order_question")
    private long order;

}