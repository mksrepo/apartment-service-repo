package com.cog.apartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ApartmentApplication {
	
	private static final Logger logger =LoggerFactory.getLogger(ApartmentApplication.class);

	public static void main(String[] args) {	
		SpringApplication.run(ApartmentApplication.class, args);
	}

}
