package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int count, @RequestParam String title ){
        return quizService.createQuiz(category,count,title);
    }

    @GetMapping("get")
    public ResponseEntity<List<Quiz>> getQuiz(@RequestParam Integer quiz){
        return quizService.getQuiz(quiz);
    }
}
