package com.example.ind2cw.service;

import com.example.ind2cw.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
