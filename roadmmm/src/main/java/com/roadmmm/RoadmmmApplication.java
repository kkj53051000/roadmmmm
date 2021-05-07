package com.roadmmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.roadmmm"})
@SpringBootApplication
public class RoadmmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoadmmmApplication.class, args);
	}

}