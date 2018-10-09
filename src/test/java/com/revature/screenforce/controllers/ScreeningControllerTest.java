package com.revature.screenforce.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Screening;

import static io.restassured.RestAssured.given;

/**
 * Question Tests using JUnit
 *
 * @author Omar Guzman | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ScreeningControllerTest {

	@LocalServerPort
	private int port;

	@Test
	public void testSoftSkillViolationByScreeningID() {
		given()
				.port(port)
				.when()
				.get("/screening/{id}/violations", 2)
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetAllScheduledScreenings() {
		given()
				.port(port)
				.when()
				.get("/screening/scheduled")
				.then()
				.statusCode(200);
	}


	@Test
	public void testUpdateScreening() {
		Screening screening = new Screening();
		screening.setScreeningId(2);
		screening.setGeneralCommentary("Testing");
		given()
				.port(port)
				.contentType("application/json")
				.body(screening)
				.when()
				.put("/screening/update")
				.then()
				.statusCode(200);
	}

	@Test
	public void testCreateEmptyScreening() {
		Screening s = new Screening();
		given()
				.port(port)
				.contentType("application/json")
				.body(s)
				.when()
				.post("/screening/new")
				.then()
				.statusCode(400);
	}

	@Test
	public void testCreateNewScreening() {
		Screening sc = new Screening(null, 3, 0, null, "Test", "Test1", null, null, null, null, null);

		given()
				.port(port)
				.contentType("application/json")
				.body(sc)
				.when()
				.post("screening/new")
				.then()
				.statusCode(200);
	}
}
