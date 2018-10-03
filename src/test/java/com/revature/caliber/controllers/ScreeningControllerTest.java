package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Screening;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
		.get("/{id}/violations",2)
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
	public void testCreateScreening() {
		Screening screening = new Screening();

		given()
				.port(port)
				.contentType("application/json")
				.body(screening)
				.when()
				.post("/screening/new")
				.then()
				.statusCode(200);
	}

	@Test
	public void testUpdateScreening() {
		fail("Not yet implemented");
	}

}
