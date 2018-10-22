package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.services.QuestionScoreService;
import com.revature.screenforce.services.ScreeningService;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class QuestionScoreServiceTest {

	@Autowired
	QuestionScoreService questionScoreService;

	@Autowired
	ScreeningService screeningService;

	@Test
	public void testSave() {
		SimpleQuestionScore score = new SimpleQuestionScore(123, null, 4.0, "Did well", new Date());
		assertNotNull(questionScoreService.save(score));
	}

	@Test
	public void testSaveNullObject() {
		SimpleQuestionScore score = null;
		assertNull(questionScoreService.save(score));
	}

	@Test
	public void testSaveEmptyScore() {
		SimpleQuestionScore score = new SimpleQuestionScore();
		assertNull(questionScoreService.save(score));
	}

	@Test
	public void findByScreeningId() {
		Screening screening = screeningService.getScreening(4323);
		questionScoreService.save(new SimpleQuestionScore(123, screening, 4.0, "Did well", new Date()));
		assertEquals(1, questionScoreService.findByScreeningId(4323).size());
	}
	
	@Test
	public void existById() {
		assertTrue(questionScoreService.existsById(4321));
	}
	
	@Test
	public void existByIdFail() {
		questionScoreService.existsById(0);
		assertThatNullPointerException();
	}
}