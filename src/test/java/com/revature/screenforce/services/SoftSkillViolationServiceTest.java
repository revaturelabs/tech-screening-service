package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.services.ScreeningService;
import com.revature.screenforce.services.SoftSkillViolationService;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
public class SoftSkillViolationServiceTest {

	@Autowired
	SoftSkillViolationService softSkillViolationService;

	@Autowired
	ScreeningService screeningService;

	@Test
	public void testGetAllByScreeningId() {
		assertEquals(1, softSkillViolationService.getAllByScreeningId(4321).size());
	}

	@Test
	public void testGetAllByScreeningIdBadId() {
		assertEquals(0, softSkillViolationService.getAllByScreeningId(1).size());
	}

	@Test
	public void testSaveViolation() {
		int lengthBefore = softSkillViolationService.getAllByScreeningId(4321).size();
		SoftSkillViolation violation = new SoftSkillViolation(123, screeningService.getScreening(4321), null, "Looked like a hobo", new Date());
		softSkillViolationService.save(violation);
		int lengthAfter = softSkillViolationService.getAllByScreeningId(4321).size();
		assertEquals(lengthBefore + 1, lengthAfter);
	}

	@Test
	public void testSaveNullObject() {
		SoftSkillViolation violation = null;
		assertNull(softSkillViolationService.save(violation));
	}

	@Test
	public void testSaveEmptyViolation() {
		SoftSkillViolation violation = new SoftSkillViolation();
		assertNull(softSkillViolationService.save(violation));
	}

	@Test
	public void testDeleteViolation() {
		int lengthBefore = softSkillViolationService.getAllByScreeningId(4321).size();
		softSkillViolationService.delete(4321);
		int lengthAfter = softSkillViolationService.getAllByScreeningId(4321).size();
		assertEquals(lengthBefore - 1, lengthAfter);
	}
	
	//Wilber: implemented get all test
	@Test
	public void testGetAllNotNull() {
		assertNotNull(softSkillViolationService.getAll());
	}
	
}