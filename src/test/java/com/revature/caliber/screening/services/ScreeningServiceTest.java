
package com.revature.caliber.screening.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.Candidate;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.Application;
import com.revature.caliber.screening.data.ScreeningRepository;
import com.revature.caliber.screening.wrappers.EndingWrapper;

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
	public final void testChangeAboutMeCommentaryByScreeningId() {
		String splargh = "splargh";
		ss.updateAboutMeComment(splargh, 1);
		Assert.assertEquals(sr.findOne(1).getAboutMeCommentary(), splargh);
	}
	
	@Test
	public final void testChangeGeneralByScreeningId() {
		String splargh = "splargh";
		ss.updateGeneralComment(splargh, 1);
		Assert.assertEquals(sr.findOne(1).getAboutMeCommentary(), splargh);
	}
	
	@Test
	public final void testEndingScreening() {
		Screening s = new Screening();
		Candidate c = new Candidate();
		c.setId(1);
		s.setCandidate(c);
		s.setTrainerId(1);
		s = sr.save(s);
		EndingWrapper ew = new EndingWrapper();
		ew.setScreeningId(s.getScreeningId());
		ew.setStatus("SCREENED");
		ss.endScreening(ew);
		Assert.assertEquals(sr.findOne(s.getScreeningId()).getStatus(), "SCREENED");
	}
	

}
