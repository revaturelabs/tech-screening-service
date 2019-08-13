package com.revature.screenforce.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.services.ScreeningServiceImpl;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ScreeningServiceTest {
	
	@Autowired
	ScreeningService screeningService;
	
	Screening sc18;
	ScheduledScreening ss;
	
	@Before
	public void setup() {
		ScheduledScreening ss = new ScheduledScreening();
		sc18 = new Screening (0, null, 3,2, (Double)50d,"intoComment","generalComment","softSkillComment", new Date(), new Date(), false, "Completed");
	}
	
	@Test
	@Transactional
	public void testGetScreeningById() {
		Screening sc = screeningService.getScreeningById(4321);
		assertNotNull(sc);
	}
	
//	@Test
//	@Transactional
//	public void testGetScreeningByIdNull() {
//		Screening sc = screeningService.getScreeningById(9999);
//		assertNull(sc);
//	}
	
	@Test
	public void testGetScreening() {
		double sum = screeningService.getScreening(4322).getCompositeScore();
		assertEquals(50.0, sum, 0);
	}

	@Test
	public void testCreateScreening() {
//		Screening sc = new Screening(0, null, 3, 0, null, "Test", "Test1", null, null, null, null, null);
		assertNotNull(screeningService.createScreening(sc18));
	}

	@Test
	public void testCreateNullScreening() {
		Screening sc = null;
		assertNull(screeningService.createScreening(sc));
	}

	@Test
	public void testCreateEmptyScreening() {
		Screening sc = new Screening();
		assertNull(screeningService.createScreening(sc));
	}

	@Test
	public void testUpdateScreening() {
		Screening screening = screeningService.getScreening(4322);
		double expected = 55.0;
		screening.setCompositeScore(55.0);
		screeningService.updateScreening(screening);
		double actual = screeningService.getScreening(4322).getCompositeScore();
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testUpdateNullScreening() {
		Screening screening = null;
		assertNull(screeningService.updateScreening(screening));
	}

	@Test
	public void testUpdateEmptyScreening() {
		Screening screening = new Screening();
		assertNull(screeningService.updateScreening(screening));
	}
	
	@Test
	public void existById() {
		assertTrue(screeningService.existsById(4321));
	}
	
	@Test
	public void existByIdFail() {
		screeningService.existsById(0);
		assertThatNullPointerException();
	}
	
	@Test
	public void findAllScreening() {
		int firstSc = screeningService.getAllScreening().size();
		screeningService.createScreening(sc18);
		assertEquals((firstSc+1), screeningService.getAllScreening().size());
	}
}
