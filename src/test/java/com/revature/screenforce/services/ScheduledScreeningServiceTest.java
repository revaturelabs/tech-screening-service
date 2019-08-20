package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

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
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.data.ScheduledScreeningRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ScheduledScreeningServiceTest {
	
	@Mock
	private ScheduledScreeningRepository ssMock;
	
	@InjectMocks
	private ScheduledScreeningServiceImpl scheduledScreeningService;
	
	private ScheduledScreening schScreening;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		schScreening = new ScheduledScreening();
		schScreening.setSkillTypeId(1234);
	}
	
	@Test
	public void testFindByStatusScreened() {
		ArrayList<ScheduledScreening> testList = new ArrayList<>();
		testList.add(new ScheduledScreening());
		when(ssMock.findAllByScheduledStatus(ScheduledStatus.SCREENED)).thenReturn(testList);
		assertEquals(scheduledScreeningService.findByStatus(ScheduledStatus.SCREENED).isEmpty(), false);
	}

	@Test
	public void testFindByStatusPending() {
		ArrayList<ScheduledScreening> testList = new ArrayList<>();
		testList.add(new ScheduledScreening());
		when(ssMock.findAllByScheduledStatus(ScheduledStatus.PENDING)).thenReturn(testList);
		assertEquals(scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).isEmpty(), false);
	}

	@Test
	public void testUpdateStatus() {
		when(ssMock.findById(1234)).thenReturn(Optional.of(schScreening));
		scheduledScreeningService.updateStatus(1234);
		verify(ssMock).save(any(ScheduledScreening.class));
	}

	@Test
	public void testUpdateStatusBadId() {
		int lengthBefore = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		scheduledScreeningService.updateStatus(1);
		int lengthAfter = scheduledScreeningService.findByStatus(ScheduledStatus.PENDING).size();
		assertEquals(lengthBefore, lengthAfter);
	}
}