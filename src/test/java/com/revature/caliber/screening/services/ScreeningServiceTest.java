package com.revature.caliber.screening.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.Application;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.wrappers.StartingWrapper;

/**
 * Scheduled Screening Repository Testing class
 * 
 * @author Thomas Santillan | 1805-WVU-JULY27 | 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScreeningServiceTest {
	
	@Autowired
	ScreeningService ss;
	
	@Autowired
	ScreeningRepository sr;
		
	@Test
	public final void testServiceSave() {
		StartingWrapper sw = new StartingWrapper();
		sw.setScheduledScreeningId(1);
		sw.setTrainerId(1);
		Screening screening = ss.setPending(sw);
		Assert.assertTrue(screening.getScreeningId() != 0);
		Assert.assertEquals("PENDING", screening.getStatus());
	}
}
