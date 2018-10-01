package com.revature.caliber.data;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Candidate;
import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Scheduled Screening Repository Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScheduledScreeningRepositoryTest {
	
	@Autowired
	ScheduledScreeningRepository ssr;
	
	@Test
	public void saveObjectTest() {
		ScheduledScreening scheduledScreening = new ScheduledScreening();
		scheduledScreening.setCandidate(new Candidate());
		scheduledScreening.getCandidate().setCandidateId(1);
		scheduledScreening.setTrainer(1);
		
		ssr.save(scheduledScreening);
		
		assertTrue(scheduledScreening.getScheduledScreeningId() != 0);
	}
	
	@Test
	public void findPendingTest() {
		List<ScheduledScreening> scheduledScreenings = ssr.findAllByScheduledStatus(ScheduledStatus.PENDING);
		assertTrue(scheduledScreenings != null && !scheduledScreenings.isEmpty());
	}
	
}
