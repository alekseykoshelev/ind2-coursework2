package com.example.ind2cw.repository;

import com.example.ind2cw.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
