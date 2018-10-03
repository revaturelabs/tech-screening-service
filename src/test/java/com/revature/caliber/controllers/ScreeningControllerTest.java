package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
public class ScreeningControllerTest {

	@LocalServerPort
	private int port;
	
	@Test
	public void testSoftSkillViolationByScreeningID(){
		given()
		.port(port)
		.when()
		.get("/screening/{id}/violations",2)
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
	public void testCreateScreening() {	
		Screening s = new Screening();
		given()
				.port(port)
				.contentType("application/json")
				.body(s)
				.when()
				.post("/screening/new")
				.then()
				.statusCode(200);
	}

}
