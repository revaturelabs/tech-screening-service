package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.data.QuestionScoreRepository;

@RunWith(SpringRunner.class)
public class QuestionScoreServiceTest {
	
	@Mock
	private QuestionScoreRepository qsMock;

	@InjectMocks
	private QuestionScoreServiceImpl questionScoreService;
	
	private SimpleQuestionScore score;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		LocalDateTime currentDate = LocalDateTime.now(); 
		score = new SimpleQuestionScore(123, null, 4.0, "Did well", currentDate);
	}

	@Test
	public void testSave() {
		when(qsMock.save(any(SimpleQuestionScore.class))).thenReturn(score);
		assertNotNull(questionScoreService.save(score));
	}

	@Test
	public void testSaveNullObject() {
		SimpleQuestionScore nullScore = null;
		assertNull(questionScoreService.save(nullScore));
	}

	@Test
	public void testSaveEmptyScore() {
		SimpleQuestionScore emptyScore = new SimpleQuestionScore();
		assertNull(questionScoreService.save(emptyScore));
	}

	@Test
	public void findByScreeningId() {
		ArrayList<SimpleQuestionScore> testList = new ArrayList<>();
		testList.add(score);
		when(qsMock.findAllByScreeningScreeningId(anyInt())).thenReturn(testList);
		assertEquals(1, questionScoreService.findByScreeningId(4323).size());
	}
	
	@Test
	public void existById() {
		when(qsMock.existsById(anyInt())).thenReturn(true);
		assertTrue(questionScoreService.existsById(4321));
	}
	
	@Test(expected = NullPointerException.class)
	public void existByIdFail() {
		when(qsMock.existsById(0)).thenThrow(new NullPointerException());
		questionScoreService.existsById(0);
	}
	
	// 8-20-19 test added for: 5/28 JU - addition for back-end re-factor
	@Test
	public void testGetAll() {
		ArrayList<SimpleQuestionScore> testList = new ArrayList<>();
		testList.add(score);
		when(qsMock.findAll()).thenReturn(testList);
		assertEquals(1, questionScoreService.getAll().size());
	}
}