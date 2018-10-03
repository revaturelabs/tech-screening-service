package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.ViolationType;

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
		int violationTypeId = 4322;
		ViolationType v = violationTypeService.getViolationType(violationTypeId);
		
		assertEquals(violationTypeId,v.getViolationTypeId());		 
	}

	@Test
	public void testGetAll() {
		int vList = violationTypeService.getAll().size();
		assertEquals(vList,violationTypeService.getAll().size());
	}

}
