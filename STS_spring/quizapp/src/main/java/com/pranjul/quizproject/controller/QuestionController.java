package com.pranjul.quizproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranjul.quizproject.dto.Question;
import com.pranjul.quizproject.exception.CustomException;
import com.pranjul.quizproject.exception.ResourceNotFoundException;
import com.pranjul.quizproject.service.QuestionService;

@RestController
@RequestMapping("question")

public class QuestionController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	QuestionService questionservice;

	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> Questionall() {
		// System.out.println(questionservice.allquestions());
		logger.info("fetching all question");
		List<Question> questions = questionservice.allquestions();
		// return new ResponseEntity<>(questions,HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(questions);
		// return questionservice.allquestions();

	}

	@GetMapping("bycategory/{category}")

	public ResponseEntity<List<Question>> QuestionByCategory(@PathVariable String category) {
		try {
			logger.info("fetching by category:{}", category);
			List<Question> question = questionservice.CategoryQuestion(category);
			return ResponseEntity.status(HttpStatus.FOUND).body(question);
		} catch ( CustomException e) {
			throw new CustomException("Category not found" + category);
			
		}
	}

	@PostMapping("add")

	public String AddQuestion(@RequestBody Question question) {
		try {
			logger.info("Adding a Question :{}", question);
			return questionservice.AddQuestion(question);
		} catch (CustomException e) {
			logger.error("No addition " + question);
			throw new CustomException("We added nothing new" + question);
		}
	}

	@DeleteMapping("delete/{category}")
	public ResponseEntity<String> DeleteByCategory(@PathVariable String category) {
		try {
			logger.info("Deleting question by category :{}", category);
			String Category = questionservice.DeleteByCategory(category);
			return ResponseEntity.status(HttpStatus.OK).body(Category);
			//return questionservice.DeleteByCategory(category);
		} catch (ResourceNotFoundException e) {
			logger.error("Category Not found" + category , e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
			//throw new ResourceNotFoundException("No category found " + category);
		}
	}

	@PutMapping("update/{id}")
	public ResponseEntity<String> UpdateById(@PathVariable Integer id, @RequestBody Question question) {
		logger.info("Updating question in id: {} with data: {}", id, question);
		String result = questionservice.UpdateById(id, question);
		return ResponseEntity.ok(result);
	}

}