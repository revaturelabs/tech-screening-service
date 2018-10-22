package com.revature.screenforce.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Candidate;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.beans.Screening;

import static io.restassured.RestAssured.given;

import java.util.Date;

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
	
	Screening scDef;
	ScheduledScreening ssDef;
	Candidate candDef;
	
	@Before
	public void setup() {
		candDef = new Candidate(0, "elawrence@mailinator.com","Lawrence, Elaine","700-864-8901","www.me.com","e@skype", "","","","","","");
		ssDef =  new ScheduledScreening(0, candDef, ScheduledStatus.PENDING, 6, new Date());
		scDef = new Screening (4321, ssDef, 3,2, (Double)50d,"intoComment","generalComment","softSkillComment", new Date(), new Date(), false, "Completed");
	}
	
	@Test
	public void testGetAllScreening() {
		given()
				.port(port)
				.when()
				.get("/screening/all")
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
				.post("/screening/new")
				.then()
				.statusCode(400);
	}

	@Test
	public void testCreateNewScreening() {
		Screening sc = new Screening(0, null, 3, 0, null, "Test", "Test1", null, null, null, null, null);
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
