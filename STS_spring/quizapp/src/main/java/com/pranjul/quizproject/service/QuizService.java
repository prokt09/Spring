
package com.pranjul.quizproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranjul.quizproject.dao.QuestionDao;
import com.pranjul.quizproject.dao.QuizDao;
import com.pranjul.quizproject.dto.Question;
import com.pranjul.quizproject.dto.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizdao;


	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<String> CreateQuiz(String category, int numQ, String title, int id) {

		List<Question> question = questiondao.FindRandomQuestionByCategory(numQ, category);

		Quiz quiz = new Quiz();
		quiz.setId(id);
		quiz.setTitle(title);
		quiz.setQuestions(question);

		quizdao.save(quiz);
		return ResponseEntity.status(HttpStatus.CREATED).body("Sucess");
	}

}
