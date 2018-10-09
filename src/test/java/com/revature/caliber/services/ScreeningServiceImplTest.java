package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Screening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ScreeningServiceImplTest {
	@Autowired
	ScreeningServiceImpl screeningService;

	@Test
	public void testGetScreening() {
		double sum = screeningService.getScreening(4322).getCompositeScore();
		assertEquals(50.0, sum, 0);
	}

	@Test
	public void testCreateScreening() {
		Screening sc = new Screening(null, 3, 0, null, "Test", "Test1", null, null, null, null, null);
		assertNotNull(screeningService.createScreening(sc));
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
}
