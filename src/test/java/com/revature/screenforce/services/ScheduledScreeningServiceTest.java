package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.services.ScheduledScreeningService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
public class ScheduledScreeningServiceTest {
	
	@Autowired
	ScheduledScreeningService scheduledScreeningService;

	@Test
	public void testFindByStatusScreened() {
		assertEquals(10, scheduledScreeningService.findByStatus(ScheduledStatus.SCREENED).size());
	}

	@Test
	public void testFindByStatusPending() {
		assertEquals(9, scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size());
	}

	@Test
	public void testUpdateStatus() {
		int lengthBefore = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		scheduledScreeningService.updateStatus(4324);
		int lengthAfter = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		assertEquals(lengthBefore - 1, lengthAfter);
	}

	@Test
	public void testUpdateStatusBadId() {
		int lengthBefore = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		scheduledScreeningService.updateStatus(1);
		int lengthAfter = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		assertEquals(lengthBefore, lengthAfter);
	}
}