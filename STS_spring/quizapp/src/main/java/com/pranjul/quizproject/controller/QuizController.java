
package com.pranjul.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranjul.quizproject.service.QuizService;

@RestController

@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;

	@PostMapping("create")
	public ResponseEntity<String> Quiz(@RequestParam String category, @RequestParam int id, @RequestParam int numQ,
			@RequestParam String title) {
		ResponseEntity<String> result = quizservice.CreateQuiz(category, numQ, title, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(result.getBody());
	}

}
