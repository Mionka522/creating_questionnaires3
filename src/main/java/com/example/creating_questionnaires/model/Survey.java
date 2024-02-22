package com.example.creating_questionnaires.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Data
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner")
    private List<Question> questions;

    @Column(name = "userIdOwner")
    private int userIdOwner;
    public Survey() {
        this.questions = new ArrayList<>();
    }


}