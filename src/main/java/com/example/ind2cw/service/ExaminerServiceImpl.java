package com.example.ind2cw.service;

import com.example.ind2cw.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService,
                               @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allJavaQuestions = javaQuestionService.getAll();
        var allMathQuestions = mathQuestionService.getAll();
        if (allMathQuestions.size() + allJavaQuestions.size() < amount) {
            throw new QuestionNotEnoughException();
        }
        if (allMathQuestions.size() + allJavaQuestions.size() == amount) {
            var all = new HashSet<Question>();
            all.addAll(allJavaQuestions);
            all.addAll(allMathQuestions);
            return all;
        }

        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() < amount) {
            questions.add(
                    random.nextBoolean()
                            ? javaQuestionService.getRandomQuestion()
                            : mathQuestionService.getRandomQuestion());
        }
        return questions;
    }
}
