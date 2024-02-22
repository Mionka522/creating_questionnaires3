package com.example.creating_questionnaires.controlleers;


import com.example.creating_questionnaires.model.Survey;
import com.example.creating_questionnaires.service.AnswerService;
import com.example.creating_questionnaires.service.QuestionService;
import com.example.creating_questionnaires.service.SurveyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/survey")
public class SurveyController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final AnswerService answerService;


    public SurveyController(SurveyService surveyService, QuestionService questionService, AnswerService answerService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.answerService = answerService;
    }
    @GetMapping()
    public String profile() {
        System.out.println("Идем в профиль!");
        return "/survey/profile";
    }

    @GetMapping("/new")
    //страница добавления нового опроса
    public String newSurvey() {

        return "/survey/new";
    }

    @PostMapping("/new")
    public String create(@RequestBody String surveyJSON) {
        System.out.println(surveyJSON);
        ObjectMapper mapper = new ObjectMapper();
        Survey survey;
        try {
            survey = mapper.readValue(surveyJSON, Survey.class);
            System.out.println(survey);
        } catch (Exception e) {
            System.out.println("Ошибка при преобразовании JSON: " + e.getMessage());
            return null;
        }

        // Сохраняем объект Survey в базу данных
        surveyService.save(survey);

        // Сохраняем связанные объекты Question и Answer в базу данных

        System.out.println("Успешное сохранение!");
        return "redirect:/survey";
    }
}

