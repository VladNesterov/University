package com.example.demo.entity;

import jdk.internal.jline.internal.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class QuizEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @Nullable
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "link_quiz")
    private List<QuestionEntity> questionEntities;

}