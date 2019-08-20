package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.data.ViolationTypeRepository;

@RunWith(SpringRunner.class)
public class ViolationTypeServiceTest {
	
	@Mock
	private ViolationTypeRepository vtMock;
	
	@InjectMocks
	private ViolationTypeServiceImpl violationTypeService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetViolationType() {
		ViolationType test = new ViolationType(1234, "TypeText", "TypeDescription");
		when(vtMock.findById(1234)).thenReturn(Optional.of(test));
		assertNotNull(violationTypeService.getViolationType(1234));
	}

	@Test
	public void testGetViolationTypeNull() {
		when(vtMock.getOne(1)).thenReturn(null);
		assertNull(violationTypeService.getViolationType(1));
	}

	@Test
	public void testGetAll() {
		ArrayList<ViolationType> testList = new ArrayList<>();
		testList.add(new ViolationType());
		when(vtMock.findAll()).thenReturn(testList);
		assertEquals(1, violationTypeService.getAll().size());
	}

}
