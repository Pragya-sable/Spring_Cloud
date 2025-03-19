package com.example.question_service.service;


import com.example.question_service.dao.QuestionDAO;
import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public String addQuestion(Question question) {
         questionDAO.save(question);
         return "Success";
    }

    /*public String updateQuestion(String category,Question question) {
        ResponseEntity<List<Question>> ques = getQuestionByCategory(category);
        ques.setQuestion_title(question.getQuestion_title());
        ques.setOption1(question.getOption1());
        ques.setOption2(question.getOption2());
        ques.setOption3(question.getOption3());
        ques.setOption4(question.getOption4());
        ques.setDifficulty_level(question.getDifficulty_level());
        ques.setRight_answer(question.getRight_answer());

        questionDAO.save(ques);
        return "Update";
    }*/

    public String deleteQuestion(Integer id) {
        questionDAO.deleteById(id);
        return "Delete";
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer Que) {
        List<Integer> questionList = questionDAO.findRandomQuestionsByCategory(category,Que);
         return new ResponseEntity<>(questionList,HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> question_id) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Integer id : question_id){
            questions.add(questionDAO.findById(id).get());
        }

        for(Question question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestion_title(question.getQuestion_title());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);

        }

        return  new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right = 0;
        for(Response response : responses){
            Question question = questionDAO.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRight_answer())){
                right++;
            }

        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
