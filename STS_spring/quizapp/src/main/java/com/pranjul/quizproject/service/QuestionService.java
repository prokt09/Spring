package com.pranjul.quizproject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pranjul.quizproject.dao.QuestionDao;
import com.pranjul.quizproject.dto.Question;
import com.pranjul.quizproject.exception.ResourceNotFoundException;

@Service
public class QuestionService {

	private final static Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionDao questiondao;

	public List<Question> allquestions() {
		// System.out.println(questiondao.findAll());
		logger.debug("Fetching all questions from the database");
		return questiondao.findAll();

		// return Question;

	}

	public List<Question> CategoryQuestion(String category) {
		logger.debug("Fetching questions for category: {}", category);
		return questiondao.findByCategory(category);
	}

	public String AddQuestion(Question question) {
		try {
			questiondao.save(question);
			return "success";
		} catch (Exception e) {
			logger.error("Error adding question: {}", e.getMessage(), e);
			return "Failed Add question";
		}
	}

	@Transactional
	public String DeleteByCategory(String category) {
		try {
			questiondao.deleteByCategory(category);
			logger.info("Deleting questions in category: {}", category);
			return "Deleted";
		} catch (ResourceNotFoundException e) {
			logger.error("Error deleting questions in category {}: {}", category, e.getMessage(), e);
			return "Failed Delete";
		}
	}

	@Transactional
	public String UpdateById(Integer id, Question question) {
		try {
			questiondao.updatebyid(id ,  question.getQuestionTitle(),question.getCategory(),question.getDifficultylevel(),
					question.getOption1(),question.getOption2(),question.getOption3(),
					question.getOption4(),question.getRightanswer());
			logger.info("Updating question for category: {} with data: {}", id, question);
			return "updated";
		} catch (Exception e) {
			logger.error("Error updating question in category {}: {}", id, e.getMessage(), e);
			return "Failed update";
		}

	}

}
