package com.revature.caliber.screening.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.Candidate;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.Application;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.wrappers.StartingWrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScreeningServiceTest {
	
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningService screeningService;
	
	@Autowired
	ScreeningRepository screeningRepo;
		
	@Test
	public final void testServiceSave() {
		StartingWrapper sw = new StartingWrapper();
		sw.setScheduledScreeningId(1);
		sw.setTrainerId(1);
		Screening screening = screeningService.setPending(sw);
		assertTrue(screening.getScreeningId() != 0);
		assertEquals("PENDING", screening.getStatus());
	}
}
