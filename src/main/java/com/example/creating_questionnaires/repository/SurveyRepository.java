package com.example.creating_questionnaires.repository;

import com.example.creating_questionnaires.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
