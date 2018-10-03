package com.revature.caliber.data;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SoftSkillViolation;
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
public class SoftSkillViolationRepositoryTest {
	
	@Autowired
	SoftSkillViolationRepository ssvr;
	
	@Test
	public void findByScreeningScreeningIdTestNotNull() {
		assertNotNull(ssvr.findAllByScreeningScreeningId(1));
	}
	
	@Test
	public void findByScreeningScreeningIdTest() {
		List<SoftSkillViolation> ssv = ssvr.findAllByScreeningScreeningId(1);
		assertTrue(ssv.size() != 0);
	}
}
