package com.example.L08springbootmvcannotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L08SpringBootMvcAnnotationsApplication {

	private static Logger logger = LoggerFactory.getLogger(L08SpringBootMvcAnnotationsApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(L08SpringBootMvcAnnotationsApplication.class, args);


		logger.error("Its error log");

		logger.info("Its info log");

	}

}
