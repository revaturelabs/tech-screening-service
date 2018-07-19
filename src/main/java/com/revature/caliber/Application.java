package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println( Class.forName("oracle.jdbc.driver.OracleDriver"));
		SpringApplication.run(Application.class, args);
	}
	
}