package com.example.ind2cw.controller;

import com.example.ind2cw.model.Question;
import com.example.ind2cw.service.MathQuestionService;
import com.example.ind2cw.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("math") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    public Collection<Question> all() {
        return questionService.getAll();
    }
}
