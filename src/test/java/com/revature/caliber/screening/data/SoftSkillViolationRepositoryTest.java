package com.revature.caliber.screening.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.screening.Application;

/**
 * Soft Skill Violation Repository Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class SoftSkillViolationRepositoryTest {
	
	@Autowired
	SoftSkillViolationRepository ssvr;
	
	@Test
	public void findByScreeningScreeningIdTestNotNull() {
		assertNotNull(ssvr.findByScreeningScreeningId(1));
	}
	
	@Test
	public void saveSoftSkillFindByscreeningScreeningIdTest() {
		SoftSkillViolation ssv = ssvr.findByScreeningScreeningId(1);
		assertTrue(ssv.getScreening().getScreeningId() == 1);
	}
}
