package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.ScheduledScreening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Scheduled Screening Service Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScheduledScreeningServiceTest {
	
	@Autowired
	ScheduledScreeningService sss;
	
	
	@Test
	public void findPendingTest() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("PENDING");
		assertTrue(scheduledScreenings != null && !scheduledScreenings.isEmpty());
	}
	
	
	@Test
	public void findPendingTestIllegalArgument() {
		List<ScheduledScreening> scheduledScreenings = sss.findByStatus("invalid input");
		assertTrue(scheduledScreenings == null);
	}
	
    @Test
    public void updateStatusTest() {
        List<ScheduledScreening> scheduledScreenings = sss.findByStatus("PENDING");
        int count = scheduledScreenings.size();

        ScheduledScreening scheduledScreening = scheduledScreenings.get(0);
        sss.updateStatus(scheduledScreening.getScheduledScreeningId());
        scheduledScreenings = sss.findByStatus("PENDING");

        assertTrue(count > scheduledScreenings.size());
    }
	
	
}
