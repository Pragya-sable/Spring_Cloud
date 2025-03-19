package com.example.demoquizapp.service;

import com.example.demoquizapp.dao.QuestionDAO;
import com.example.demoquizapp.model.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

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

    public Question getQuestionByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
         questionDAO.save(question);
         return "Success";
    }

    public String updateQuestion(String category,Question question) {
        Question ques = getQuestionByCategory(category);
        ques.setQuestion_title(question.getQuestion_title());
        ques.setOption1(question.getOption1());
        ques.setOption2(question.getOption2());
        ques.setOption3(question.getOption3());
        ques.setOption4(question.getOption4());
        ques.setDifficulty_level(question.getDifficulty_level());
        ques.setRight_answer(question.getRight_answer());

        questionDAO.save(ques);
        return "Update";
    }

    public String deleteQuestion(Integer id) {
        questionDAO.deleteById(id);
        return "Delete";
    }
}
