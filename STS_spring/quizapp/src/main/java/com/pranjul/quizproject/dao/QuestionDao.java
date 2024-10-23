package com.pranjul.quizproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pranjul.quizproject.dto.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	void deleteByCategory(String category);

	@Modifying
	@Transactional
	@Query("UPDATE Question q SET  q.difficultylevel = :difficultylevel,"
			+ " q.option1 = :option1, q.option2 = :option2, q.option3 = :option3, q.option4 = :option4,"
			+ "q.questionTitle = :questionTitle,q.category = :category, q.rightAnswer = :rightanswer WHERE q.id = :id")
	void updatebyid(@Param("id") Integer id, @Param("questionTitle") String questionTitle, @Param("category") String category,
			 @Param("difficultylevel") String difficultylevel, @Param("option1") String option1, @Param("option2") String option,
			 @Param("option3") String option3, @Param("option4") String option4, @Param("rightanswer") String rightanswer);

	@Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Question> FindRandomQuestionByCategory(int numQ, String category);

	

}
