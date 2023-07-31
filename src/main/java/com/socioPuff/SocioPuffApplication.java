package com.socioPuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SocioPuffApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SocioPuffApplication.class);

	public static void main(String[] args) {

		LOGGER.info("SocioPuffApplication application started at : " + LocalDate.now());

		SpringApplication.run(SocioPuffApplication.class, args);
	}

}
