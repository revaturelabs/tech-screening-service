package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SimpleQuestionScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Question Score Service Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class QuestionScoreServiceTest {
	
	
	@Autowired
	QuestionScoreService qss;
	
	/*@Test
	public void saveObjectTest() {
		SimpleQuestionScore qs = new SimpleQuestionScore();
		qs.setQuestionId(1);
		qs.setScreening(1);
		qss.save(qs);

		assertTrue(qs.getScreening() != 0);
	}*/
	
	@Test
	public void findInterViewResultTest() {
		List<SimpleQuestionScore> interviewResults = qss.findByScreeningId(1);
		assertTrue(interviewResults != null && !interviewResults.isEmpty());
	}
	

}
