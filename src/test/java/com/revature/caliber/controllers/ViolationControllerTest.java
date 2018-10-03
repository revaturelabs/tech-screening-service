package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SoftSkillViolation;
import com.revature.caliber.services.ViolationTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static io.restassured.RestAssured.given;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ViolationControllerTest {
	@Autowired
	ViolationTypeService violationTypeService;

	@LocalServerPort
	int port;

	@Test
	public void testGetAllViolationTypes() {
		given()
				.port(port)
				.when()
				.get("/violation")
				.then()
				.statusCode(200);
	}

	@Test
	public void deleteViolationById() {
		given()
				.port(port)
				.when()
				.delete("/violation/{id}", 1)
				.then()
				.statusCode(200);
	}

	@Test
	public void deleteViolationByBadId() {
		given()
				.port(port)
				.when()
				.delete("/violation/{id}", 4321789)
				.then()
				.statusCode(404);
	}

	@Test
	public void addNewViolation() {
		SoftSkillViolation violation = new SoftSkillViolation(321, null, null, "Terrible boyo", new Date());

		given()
				.port(port)
				.when()
				.contentType("application/json")
				.body(violation)
				.post("/violation/new")
				.then()
				.statusCode(200);

	}

	@Test
	public void addNewViolationBadData() {
		SoftSkillViolation violation = new SoftSkillViolation();

		given()
				.port(port)
				.when()
				.contentType("application/json")
				.body(violation)
				.post("/violation/new")
				.then()
				.statusCode(400);
	}
}
