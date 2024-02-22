package com.example.creating_questionnaires.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    private String value;

    @Column(name = "iscorrect")
    private boolean iscorrect;

    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "idquestion")
    private Question ownerQ;
}
