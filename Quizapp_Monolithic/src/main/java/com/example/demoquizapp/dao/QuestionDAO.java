package com.example.demoquizapp.dao;

import com.example.demoquizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {

    Question findByCategory(String category);


    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :Que", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("Que") Integer Que);

}
