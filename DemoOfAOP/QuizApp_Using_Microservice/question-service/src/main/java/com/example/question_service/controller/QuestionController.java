package com.example.question_service.controller;


import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;
import com.example.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

   /* @PutMapping("/update/{category}")
    public String updateQuestion(@PathVariable String category,@RequestBody Question question){
        return questionService.updateQuestion(category,question);
    }*/
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion (@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category,   @RequestParam(name = "Que",defaultValue = "10") Integer Que){
        return questionService.getQuestionForQuiz(category,Que);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> question_id){
        return questionService.getQuestionsFromId(question_id);

    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }


}
