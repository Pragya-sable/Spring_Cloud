package com.example.demoquizapp.controller;

import com.example.demoquizapp.model.Question;
import com.example.demoquizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public Question getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

    @PutMapping("/update/{category}")
    public String updateQuestion(@PathVariable String category,@RequestBody Question question){
        return questionService.updateQuestion(category,question);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion (@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

}
