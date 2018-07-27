package com.revature.caliber.screening.services;

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
public class SoftSkillViolationServiceTest {
	
	@Autowired
	SoftSkillViolationService ssvs;
	
	@Test
	public void findByScreeningScreeningIdTestNotNull() {
		assertNotNull(ssvs.getByScreeningId(1));
	}
	
	@Test
	public void saveSoftSkillFindByscreeningScreeningIdTest() {
		SoftSkillViolation ssv = ssvs.getByScreeningId(1);
		assertTrue(ssv.getScreening().getScreeningId() == 1);
	}
}
