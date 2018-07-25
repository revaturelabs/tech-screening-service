package com.revature.caliber.screening;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.beans.Candidate;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ScreeningRepositoryTest {
	
	@Autowired
	ScreeningRepository sr;
	

	@Test
	public final void testSave() {
		Screening testScreening = new Screening();
		testScreening.setCandidate(new Candidate());
		testScreening.getCandidate().setId(0);
		testScreening.setScreeningId(0);
		testScreening.setTrainerId(0);
		sr.save(testScreening);
		assertTrue(testScreening.getScreeningId() != 0);
	}

}
