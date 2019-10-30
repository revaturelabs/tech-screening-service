package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.data.SoftSkillViolationRepository;

@RunWith(SpringRunner.class)
public class SoftSkillViolationServiceTest {
	
	@Mock
	private SoftSkillViolationRepository svMock;
	@InjectMocks
	private SoftSkillViolationServiceImpl softSkillViolationService;
	
	private Screening sc18;
	private SoftSkillViolation ssv;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ssv = new SoftSkillViolation();
		ssv.setSoftViolationId(1234); //so that it != new()
		LocalDate currentDate = LocalDate.now(); 
		LocalTime currentTime = LocalTime.now();
		LocalDateTime fromDateAndTime = LocalDateTime.of(currentDate, currentTime);
		sc18 = new Screening(4321, null, 3, 2, 50.0d, "intoComment", "generalComment", "softSkillComment",
				fromDateAndTime,fromDateAndTime, false, "Completed");
	}

	@Test
	public void testGetAllByScreeningId() {
		ArrayList<SoftSkillViolation> testList = new ArrayList<>();
		ssv.setScreening(sc18);
		testList.add(ssv);
		when(svMock.findAllByScreeningScreeningId(4321)).thenReturn(testList);
		assertEquals(1, softSkillViolationService.getAllByScreeningId(4321).size());
	}

	@Test
	public void testGetAllByScreeningIdBadId() {
		when(svMock.findAllByScreeningScreeningId(9999)).thenReturn(null);
		assertNull(softSkillViolationService.getAllByScreeningId(9999));
	}

	@Test
	public void testSaveViolation() {
		when(svMock.save(any(SoftSkillViolation.class))).thenReturn(ssv);
		assertNotNull(softSkillViolationService.save(ssv));
	}

	@Test
	public void testSaveNullObject() {
		SoftSkillViolation violation = null;
		assertNull(softSkillViolationService.save(violation));
	}

	@Test
	public void testSaveEmptyViolation() {
		SoftSkillViolation violation = new SoftSkillViolation();
		assertNull(softSkillViolationService.save(violation));
	}

	@Test(expected = Test.None.class /* no exception expected */)
	public void testDeleteViolation() {
		doNothing().when(svMock).delete(any(SoftSkillViolation.class));
	}
}