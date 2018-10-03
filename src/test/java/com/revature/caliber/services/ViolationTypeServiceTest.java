package com.revature.caliber.services;

import com.revature.caliber.Application;
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
public class ViolationTypeServiceTest {
	
	@Autowired
	ViolationTypeService violationTypeService;

	@Test
	public void testGetViolationType() {
		assertNotNull(violationTypeService.getViolationType(4321));
	}

	@Test
	public void testGetViolationTypeNull() {
		assertNull(violationTypeService.getViolationType(1));
	}

	@Test
	public void testGetAll() {
		assertEquals(3, violationTypeService.getAll().size());
	}

}
