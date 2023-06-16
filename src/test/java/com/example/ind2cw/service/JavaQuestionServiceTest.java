package com.example.ind2cw.service;

import com.example.ind2cw.model.Question;
import com.example.ind2cw.repository.JavaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    JavaRepository repository;
    @InjectMocks
    JavaQuestionService service;

    @Test
    void testAdd() {
        var expectedQuestion = new Question("q1", "q2");
        when(repository.add(anyString(), anyString())).thenCallRealMethod();
        when(repository.add(any())).thenCallRealMethod();
        when(repository.getAll()).thenCallRealMethod();

        var actual = service.add("q1", "q2");

        assertEquals("q1", actual.getQuestion());
        assertEquals("q2", actual.getAnswer());

        var all = service.getAll();
        assertEquals(1, all.size());
        assertEquals(expectedQuestion, all.iterator().next());
    }
}