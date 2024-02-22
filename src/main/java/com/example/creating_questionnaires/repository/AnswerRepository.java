package com.example.creating_questionnaires.repository;

import com.example.creating_questionnaires.model.Answer;
import com.example.creating_questionnaires.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Boolean> {
    List<Answer> findAnswerByOwnerQ(Question question);
}
