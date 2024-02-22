package com.example.creating_questionnaires.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idquestion;

    @Column(name = "question")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private Survey owner;

    @OneToMany(mappedBy = "ownerQ")
    private List<Answer> answers;
    public Question() {
        this.answers = new ArrayList<>();
    }
}
