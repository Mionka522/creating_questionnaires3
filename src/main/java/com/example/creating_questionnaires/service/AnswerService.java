package com.example.creating_questionnaires.service;

import com.example.creating_questionnaires.model.Answer;
import com.example.creating_questionnaires.model.Question;
import com.example.creating_questionnaires.model.Survey;
import com.example.creating_questionnaires.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AnswerService {
    private final AnswerRepository answerRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }


    public List<Answer> findAnswerByOwnerQ(Question question) {
        return answerRepository.findAnswerByOwnerQ(question);
    };
    @Transactional
    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
