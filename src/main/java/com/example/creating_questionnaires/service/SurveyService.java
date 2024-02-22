package com.example.creating_questionnaires.service;

import com.example.creating_questionnaires.model.Survey;
import com.example.creating_questionnaires.repository.SurveyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class SurveyService {

    private final SurveyRepository surveyRepository;
    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }
    public Survey findOne(int id) {
        Optional<Survey> foundSurvey = surveyRepository.findById(id);
        return foundSurvey.orElse(null);
    }
    @Transactional
    public void save(Survey survey) {
        surveyRepository.save(survey);
    }


}