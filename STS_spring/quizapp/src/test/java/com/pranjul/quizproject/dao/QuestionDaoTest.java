package com.pranjul.quizproject.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pranjul.quizproject.dto.Question;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuestionDaoTest {

	@Autowired
	QuestionDao questiondao;
	Question question;

	@BeforeAll
	void setUp() throws Exception {
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

		questiondao.save(question);
	}

	/*
	 * @AfterEach void tearDown() throws Exception {
	 *
	 * questiondao.delete(question); }
	 */

	@Test
	void findByCategoryTest() {

		String actual = "medium";
		List<Question> questionlist = questiondao.findByCategory("java");
		String Difficultylevel = questionlist.get(0).getDifficultylevel();
		// assertThat(question.getId()).isEqualTo(1)>;
		assertEquals(actual, Difficultylevel);
		System.out.println("success");

		// assertThat(Difficultylevel).isEqualTo(actual);
		// assertThat(questionlist).contains("medium");
	}
	
	@Test
	void FindByCategoryNotFoundTest() {
		List<Question> questionlist = questiondao.findByCategory("python");
		
		assertEquals(0,questionlist.size(),"No category found");
		assertThat(questionlist.isEmpty()).isTrue();
		
	}

	@Test
	void updatebyidTest() {

		Question question1 = new Question();

		question1.setId(1);
		question1.setCategory("python");
		question1.setDifficultylevel("medium");
		question1.setOption1("test5");
		question1.setOption2("test6");
		question1.setOption3("test7");
		question1.setOption4("test8");
		question1.setQuestionTitle("testcase2");
		question1.setRightanswer("righttest2");
		System.out.println(question.getId());
		questiondao.updatebyid(question1.getId(), question1.getQuestionTitle(), question1.getCategory(),
				question1.getDifficultylevel(), question1.getOption1(), question1.getOption2(), question1.getOption3(),
				question1.getOption4(), question1.getRightanswer());
		

		Optional<Question> result = questiondao.findById(question1.getId());
		assertTrue(result.isPresent(), "Date is there updated");
		Question updatedquestion = result.get();
		System.out.println(question.getRightanswer());
		System.out.println(question1.getRightanswer());
		assertThat(question1.getQuestionTitle()).isEqualTo(updatedquestion.getQuestionTitle());
		assertEquals(question1.getQuestionTitle(), updatedquestion.getQuestionTitle());

	}

	/*
	 * @Test void deleteByCategoryTest() { String actual = "java";
	 *
	 * }
	 */
	
	@AfterAll
	void tearDown() {
		questiondao.deleteAll();
	}
	

}
