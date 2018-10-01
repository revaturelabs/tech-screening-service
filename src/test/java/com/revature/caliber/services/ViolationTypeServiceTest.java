package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.ViolationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Soft Skill Violation Repository Testing class
 * 
 * @author Aaron Ware | 1805-WVU-MAY29 | Richard Orr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@Sql("/data.sql")
public class ViolationTypeServiceTest {
	
	@Autowired
	ViolationTypeService vts;
	
	@Test
	public void getViolationTypeTestNotNull() {
		ViolationType vt = vts.getViolationType(1);
		assertNotNull(vt);
	}
	
	@Test
	public void getViolationTypeTest() {
		ViolationType vt = vts.getViolationType(1);
		assertTrue(vt.getViolationId() == 1);
	}
	
	@Test
	public void getAllTestNotNull() {
		assertNotNull(vts.getAll());
	}
	
	@Test
	public void getAllTest() {
		assertTrue(vts.getAll().size() == 3);
	}
}
