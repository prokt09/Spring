package com.pranjul.quizproject.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pranjul.quizproject.dto.Question;
import com.pranjul.quizproject.service.QuestionService;

public class QuestionControllerTest {

	@Mock
	QuestionService questionservice;
	Question question;
	Question question1;
	List<Question> questionlist = new ArrayList<>();

	@InjectMocks
	QuestionController questioncontroller;

	@Autowired
	MockMvc mockmvc;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(questioncontroller).build();

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

		questionlist.add(question);
		questionlist.add(question1);

	}

	@Test
	public void QuestionalTest() throws Exception {
		when(questionservice.allquestions()).thenReturn(questionlist);
		mockmvc.perform(get("/question/allquestions")).andDo(print()).andExpect(status().isOk());

	}
}
