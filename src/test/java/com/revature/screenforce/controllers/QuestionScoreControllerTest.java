package com.revature.screenforce.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.SimpleQuestionScore;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class QuestionScoreControllerTest {

	@LocalServerPort
	private int port;
	
	@Test
	public void testGetAllQuestion() {
		given()
			.port(port)
			.when()
			.get("/questionScore/all")
			.then()
			.statusCode(200);
	}

	@Test
	public void testQuestionScore() {
		SimpleQuestionScore b = new SimpleQuestionScore(300, null, (double) 20, "Test", null);
		given()
				.port(port)
				.contentType("application/json")
				.body(b)
				.when()
				.post("/questionScore")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testQuestionScoreFail() {
		SimpleQuestionScore b = new SimpleQuestionScore();
		given()
				.port(port)
				.contentType("application/json")
				.body(b)
				.when()
				.post("/questionScore")
				.then()
				.statusCode(400);
	}


	@Test
	public void testGetScoresByScreeningIdFail() {
		given()
				.port(port)
				.when()
				.get("/questionScore/{screeningId}", 1)
				.then()
				.statusCode(404);
	}
	
	@Test
	public void testGetScoresByScreeningId() {
		given()
				.port(port)
				.when()
				.get("/questionScore/{screeningId}", 4321)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testGetSimpleQuestionScoreList() {
		given()
				.port(port)
				.when()
				.get("questionScore/all")
				.then()
				.statusCode(200);
	}
}
