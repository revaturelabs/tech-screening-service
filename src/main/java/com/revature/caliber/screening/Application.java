package com.revature.caliber.screening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@ComponentScan
@EntityScan("com.revature.caliber.beans")
public class Application {
	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(Application.class, args);
	}
}
