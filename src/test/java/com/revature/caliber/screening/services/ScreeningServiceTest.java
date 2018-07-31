package com.revature.caliber.screening.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.Candidate;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.Application;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.services.ScreeningService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScreeningServiceTest {
	
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningRepository sr;
	
	@Autowired
	ScreeningService ss;

	@Ignore
	public final void testRepositorySave() {
		Screening testScreening = new Screening();
		testScreening.setCandidate(new Candidate());
		testScreening.getCandidate().setId(1);
		testScreening.setScreeningId(0);
		testScreening.setTrainerId(1);
		sr.save(testScreening);
		assertTrue(testScreening.getScreeningId() != 0);
	}
	
	@Ignore
	public final void testServiceSave() {
		Screening testScreening = new Screening();
		testScreening.setCandidate(new Candidate());
		testScreening.getCandidate().setId(1);
		testScreening.setScreeningId(0);
		testScreening.setTrainerId(1);
		//ss.setPending(testScreening);
		assertTrue(testScreening.getScreeningId() != 0);
		assertEquals("Pending", testScreening.getStatus());
	}
}
