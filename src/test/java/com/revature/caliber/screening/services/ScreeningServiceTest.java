package com.revature.caliber.screening.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScreeningServiceTest {
	
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
	@Autowired
	ScreeningRepository sr;
	
	@Autowired
	ScreeningService ss;
	
	@Test
	public final void testServiceSave() {
		StartingWrapper screeningInfo = new StartingWrapper();
		screeningInfo.setScheduledScreeningId(1);
		screeningInfo.setSkillTypeId(1);
		screeningInfo.setTrainerId(1);
		Screening s = ss.setPending(screeningInfo);
		assertTrue(s.getScreeningId() != 0);
		assertEquals("PENDING", s.getStatus());
	}
	
	@Test
	public final void testChangeAboutMeCommentaryByScreeningId() {
		String splargh = "splargh";
		ss.updateAboutMeComment(splargh, 1);
		Assert.assertEquals(sr.findOne(1).getAboutMeCommentary(), splargh);
	}
	
	@Test
	public final void testChangeGeneralByScreeningId() {
		String splargh = "splargh";
		ss.updateGeneralComment(splargh, 1);
		Assert.assertEquals(sr.findOne(1).getGeneralCommentary(), splargh);
	}
	
	
}
