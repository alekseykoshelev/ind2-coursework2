package com.example.ind2cw.repository;

import com.example.ind2cw.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }


    public String remove(String question) {
        if (questions.removeIf(q -> q.getQuestion().equals(question))) {
            return question;
        }
        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    public int getQuestionAmount() {
        return questions.size();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
