package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.data.SoftSkillViolationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
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
		sc18 = new Screening(4321, null, 3, 2, 50.0d, "intoComment", "generalComment", "softSkillComment",
				new Date(), new Date(), false, "Completed");
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
		when(svMock.save(any(SoftSkillViolation.class))).thenReturn(new SoftSkillViolation());
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

	@Test
	public void testDeleteViolation() {
		when(svMock.delete(any(SoftSkillViolation.class))).thenReturn(true);
		assertEquals(softSkillViolationService.delete(4321), true);
	}
}