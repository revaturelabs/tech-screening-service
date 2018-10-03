package com.revature.caliber.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.revature.caliber.Application;
import com.revature.caliber.beans.SimpleQuestionScore;
import com.revature.caliber.services.QuestionScoreService;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionScoreControllerTest {
	
	@LocalServerPort
	private int port;
	
	
	@Test
	public void testQuestionScore() {
		SimpleQuestionScore b = new SimpleQuestionScore(300, null, (double) 20, "Test", null);		
		given()
			.port(port)
			.contentType("application/json")
			.body(b)
		.when()
			.post("/questionScore/new")
		.then()
			.statusCode(200);
	}


	@Test
	public void testGetScoresByScreeningId() {
		given()
			.port(port)
		.when()
			.get("/questionScore/{screeningId}", 1)
		.then()
			.statusCode(200);
	}

}
