
package com.revature.caliber.screening.services;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.screening.Application;
import com.revature.caliber.screening.data.ScreeningRepository;

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
	ScreeningService screeningService;
	
	@Autowired
	ScreeningRepository screeningRepo;
	
	@Ignore
	@Test
	public final void testChangeAboutMeCommentaryByScreeningId() {
		String splargh = "splargh";
		screeningService.updateAboutMeComment(splargh, 1);
		//assertsTrue(screeningRepo.findOne(1).getAboutMeCommentary(), splargh);
	}

}
