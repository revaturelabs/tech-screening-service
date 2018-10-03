package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.data.SoftSkillViolationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Soft Skill Violation Repository Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@Sql("/data.sql")
public class SoftSkillViolationServiceTest {
	
	@Autowired
	SoftSkillViolationService ssvs;
	
	@Autowired
	SoftSkillViolationRepository ssvr;
	
	@Autowired
	ScreeningService ss;
	
	@Test
	public void findByScreeningScreeningIdTestNotNull() {
		assertNotNull(ssvs.getAllByScreeningId(1));
	}
	
	@Test
	public void findByScreeningScreeningIdTest() {
		List<SoftSkillViolation> ssv = ssvs.getAllByScreeningId(1);
		assertTrue(ssv.size() != 0);
	}
	
	@Test
	public void saveSSVTest() {
		SoftSkillViolation ssv = new SoftSkillViolation();
		ssv.setScreening(9);
		
		ssv = ssvs.save(ssv);

		assertTrue(ssv.getSoftViolationId() != 0);
	}
	
	@Test
	public void deleteSSVTest() {
		SoftSkillViolation ssv = new SoftSkillViolation();
		ssv.setScreening(9);
		
		ssv = ssvs.save(ssv);
		ssvs.delete(ssv.getSoftViolationId());
		
		assertTrue(ssvs.getAllByScreeningId(9).size() == 0);
	}
	
	@Test
	public void screeningServiceGetTestNotNull() {
		assertNotNull(ss.getScreening(1));
	}
	
	@Test
	public void screeningServiceGetTest() {
		assertTrue(ss.getScreening(1).getScreeningId() == 1);
	}
	
}
