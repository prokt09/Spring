
  package com.pranjul.quizproject.dao;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.pranjul.quizproject.dto.Quiz;
  
  @Repository public interface QuizDao extends JpaRepository<Quiz, Integer> {
  
  
  }
 