package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.data.ScreeningRepository;

@RunWith(SpringRunner.class)
public class ScreeningServiceTest {

	@Mock
	private ScreeningRepository srMock;

	@InjectMocks
	private ScreeningServiceImpl screeningService;

	private Screening sc18;
  
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		sc18 = new Screening(4321, null, 3, 2, 50.0d, "intoComment", "generalComment", "softSkillComment",
				new Date(), new Date(), false, "Completed");
	}

	@Test
	public void testGetScreeningById() {
		when(srMock.findById(4321)).thenReturn(Optional.of(new Screening()));
		assertNotNull(screeningService.getScreeningById(4321));
	}

	@Test
	public void testGetScreening() {
		when(srMock.getOne(4321)).thenReturn(sc18);
		when(srMock.getOne(9999)).thenReturn(null);
		assertEquals(4321, sc18.getScreeningId(), 0);
		assertNotNull(screeningService.getScreening(9999));
	}

	@Test
	public void testCreateScreening() {
		when(srMock.save(any(Screening.class))).thenReturn(new Screening());
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
		when(srMock.save(any(Screening.class))).thenReturn(sc18);
		sc18.setCompositeScore(55.0);
		assertEquals(screeningService.updateScreening(sc18).getCompositeScore(), 55.0, 0);
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
		when(srMock.existsById(anyInt())).thenReturn(true);
		assertTrue(screeningService.existsById(4321));
	}

	@Test(expected = NullPointerException.class)
	public void existByIdFail() {
		when(srMock.existsById(0)).thenThrow(new NullPointerException());
		screeningService.existsById(0);
	}

	@Test
	public void findAllScreening() {
		ArrayList<Screening> testList = new ArrayList<>();
		testList.add(sc18);
		when(srMock.findAll()).thenReturn(testList);
		assertNotNull(screeningService.getAllScreenings());
	}
}