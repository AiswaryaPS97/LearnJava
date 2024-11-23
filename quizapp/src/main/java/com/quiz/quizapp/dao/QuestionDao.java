package com.quiz.quizapp.dao;

import com.quiz.quizapp.model.Question;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


    List<Question> findByCategory(String category);

    void deleteById(Question question);

    @Query(value = "SELECT * FROM QUESTION Q WHERE Q.CATEGORY = :category LIMIT :count",nativeQuery = true )
    List<Question> findRandomQuestionsBasedOnCategory(String category, int count);
}
