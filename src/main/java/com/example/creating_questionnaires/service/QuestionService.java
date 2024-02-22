package com.example.creating_questionnaires.service;

import com.example.creating_questionnaires.model.Question;
import com.example.creating_questionnaires.model.Survey;
import com.example.creating_questionnaires.repository.QuestionRepository;
import com.example.creating_questionnaires.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    public List<Question> findQuestionByOwner(Survey owner) {
        return questionRepository.findQuestionByOwner(owner);
    };

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findOne(int id) {
        Optional<Question> foundQuestion = questionRepository.findById(id);
        return foundQuestion.orElse(null);
    }
    @Transactional
    public void save(Question question) {
        questionRepository.save(question);
    }
}
