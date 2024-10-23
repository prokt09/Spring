package com.pranjul.quizproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pranjul.quizproject.dao.QuestionDao;
import com.pranjul.quizproject.dto.Question;

public class QuestionServiceTest {

	@Mock
	QuestionDao questiondao;
	AutoCloseable autocloseable;
	Question question;
	Question question1;

	@InjectMocks
	QuestionService questionservice;

	@BeforeEach
	void setUp() {
		autocloseable = MockitoAnnotations.openMocks(this);
		/*
		 * Initialized the data with constructor Question question = new Question(1,
		 * "What is Jnuit", "i am doing 1", "i am doing 2", "i am doing 3",
		 * "i am doing 4","Java", "medium", "bravo dude");
		 * 
		 * Question question1 = new Question(2, "What is second junit", "i am doing 1",
		 * "i am doing 2", "i am doing 3", "i am doing 4","Java", "easy", "Execellent");
		 */

		question = new Question();
		question.setId(1);
		question.setCategory("java");
		question.setDifficultylevel("medium");
		question.setOption1("test1");
		question.setOption2("test2");
		question.setOption3("test3");
		question.setOption4("test4");
		question.setQuestionTitle("testcase");
		question.setRightanswer("righttest");

		question1 = new Question();
		question1.setId(1);
		question1.setCategory("python");
		question1.setDifficultylevel("medium");
		question1.setOption1("test1");
		question1.setOption2("test2");
		question1.setOption3("test3");
		question1.setOption4("test4");
		question1.setQuestionTitle("testcase");
		question1.setRightanswer("righttest");

	}

	@AfterEach
	void tearDown() throws Exception {
		autocloseable.close();
	}

	@Test
	public void allquestionsTest() {

		List<Question> mockedList = new ArrayList<>();

		mockedList.add(question);
		mockedList.add(question1);
		when(questiondao.findAll()).thenReturn(mockedList);
		List<Question> questions = questionservice.allquestions();
		//System.out.println(question);
		assertFalse(mockedList.isEmpty());
		assertEquals(2, mockedList.size());
		assertThat(questions.get(0).getCategory()).isEqualTo(question.getCategory());
		assertThat(questions.get(1).getCategory()).isEqualTo(question1.getCategory());

	}
	
	@Test
	public void CategoryQuestionTest() {
		String category ="python";
		List<Question> mockedList = new ArrayList<>();
		mockedList.add(question);
		mockedList.add(question1);
		when(questiondao.findByCategory(category)).thenReturn(mockedList);
		
		List<Question> questions = questionservice.CategoryQuestion("python");
		assertThat(questions).isNotEmpty();
		for (Question currentQuestion : questions) {
			System.out.println(currentQuestion);
		}
		assertThat(questions.get(0).getCategory()).isEqualTo(question.getCategory());
		System.out.println(questions.get(0).getCategory());
		System.out.println(question1.getCategory());
		//assertEquals(1, questions.size());
		verify(questiondao).findByCategory(category); //verify that repo layer is calling the method correctly    
	}
	
	@Test
	public void AddQuestionTest() {
		
		when(questiondao.save(question)).thenReturn(question);
		 String s = questionservice.AddQuestion(question);
		 assertEquals(s, "success");
		 verify(questiondao).save(question);
		 
	}
	
}
