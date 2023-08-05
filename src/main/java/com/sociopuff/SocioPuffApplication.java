package com.sociopuff;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocioPuffApplication {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SocioPuffApplication.class);
	static org.slf4j.Marker marker;

	public static void main(String[] args) {

		if(logger.isDebugEnabled()) {
			logger.debug(marker, "Socio Puff Application application started at DEBUG MODE : " );
		}

		SpringApplication.run(SocioPuffApplication.class, args);
	}

}
