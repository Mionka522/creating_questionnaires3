package com.example.creating_questionnaires.repository;

import com.example.creating_questionnaires.model.Question;
import com.example.creating_questionnaires.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionByOwner(Survey owner);
}
