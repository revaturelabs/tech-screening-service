package com.revature.screenforce.controllers;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.SoftSkillViolation;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ViolationControllerTest {

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
	public void testGetAllViolations() {
		given()
				.port(port)
				.when()
				.get("/violation/all")
				.then()
				.statusCode(200);
	}

	@Test
	public void deleteViolationById() {
		given()
				.port(port)
				.when()
				.delete("/violation/{id}", 4321)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void deleteViolationByIdInvalidID() {
		given()
				.port(port)
				.when()
				.delete("/violation/{id}", 0)
				.then()
				.statusCode(404);
	}

	@Test
	public void addNewViolation() {
		LocalDateTime currentDate = LocalDateTime.now();
		SoftSkillViolation violation = new SoftSkillViolation(321, null, null, "Terrible boyo", currentDate);
		given()
				.port(port)
				.when()
				.contentType("application/json")
				.body(violation)
				.post("/violation")
				.then()
				.statusCode(200);

	}
	
	@Test
	public void addNewViolationFail() {
		SoftSkillViolation violation = new SoftSkillViolation();
		given()
				.port(port)
				.when()
				.contentType("application/json")
				.body(violation)
				.post("/violation")
				.then()
				.statusCode(400);

	}
	
	@Test
	public void testGetSoftSkillViolation() {
		given()
			.port(port)
			.when()
			.get("/violation/all")
			.then()
			.statusCode(200);
	}
}
