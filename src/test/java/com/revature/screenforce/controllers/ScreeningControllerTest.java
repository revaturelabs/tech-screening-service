package com.revature.screenforce.controllers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;

/**
 * Question Tests using JUnit
 *
 * @author Omar Guzman | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ScreeningControllerTest {

	@LocalServerPort
	private int port;
	
	private Screening scDef;
	
	@Before
	public void setup() {
		scDef = new Screening (4321, null, 3,2, (Double)50d,"intoComment","generalComment","softSkillComment", new Date(), new Date(), false, "Completed");
	}
	
	@Test
	public void testGetAllScreening() {
		given()
				.port(port)
				.when()
				.get("/screening")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testGetScreeningByID() {
		given()
				.port(port)
				.when()
				.get("/screening/{id}", 4321)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testGetScreeningByIDFail() {
		given()
				.port(port)
				.when()
				.get("/screening/{id}", 1)
				.then()
				.statusCode(404);
	}

	@Test
	public void testSoftSkillViolationByScreeningID() {
		SoftSkillViolation[] test = given()
				.port(port)
				.when()
				.get("/screening/{id}/violations", 4321)
				.then()
				.statusCode(200)
				.extract()
				.as(SoftSkillViolation[].class);
				assertThat(test.length).isGreaterThan(0);
	}
	
	@Test
	public void testSoftSkillViolationByScreeningIDNoViolationsReturnsEmpty() {
		SoftSkillViolation[] test = given()
				.port(port)
				.when()
				.get("/screening/{id}/violations", 4324)
				.then()
				.statusCode(200)
				.extract()
				.as(SoftSkillViolation[].class);
				assertThat(test.length).isEqualTo(0);
	}
	
	@Test
	public void testSoftSkillViolationByScreeningIDNoScreeningOfThatID() {
		given()
				.port(port)
				.when()
				.get("/screening/{id}/violations", 0)
				.then()
				.statusCode(404);
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
		Screening screening = scDef;
		screening.setGeneralCommentary("Testing");
		given()
				.port(port)
				.contentType("application/json")
				.body(screening)
				.when()
				.put("/screening/4321")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testUpdateScreeningFail() {
		Screening screening = scDef;
		screening.setGeneralCommentary("Testing");
		given()
				.port(port)
				.contentType("application/json")
				.body(screening)
				.when()
				.put("/screening/9921")
				.then()
				.statusCode(400);
	}

	@Test
	public void testCreateEmptyScreening() {
		Screening s = new Screening();
		given()
				.port(port)
				.contentType("application/json")
				.body(s)
				.when()
				.post("/screening")
				.then()
				.statusCode(400);
	}

	@Test
	public void testCreateNewScreening() {
		Screening sc = scDef;
		given()
				.port(port)
				.contentType("application/json")
				.body(sc)
				.when()
				.post("/screening")
				.then()
				.statusCode(200);
	}
}
