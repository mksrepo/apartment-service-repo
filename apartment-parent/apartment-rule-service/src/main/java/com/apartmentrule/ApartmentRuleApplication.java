package com.apartmentrule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is Micro-service responsible for Apartment Rules Management
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.apartmentrule.*")
@EntityScan(basePackages = {"com.apartmentrule.model"})
@EnableJpaRepositories(basePackages = {"com.apartmentrule.repository"})
public class ApartmentRuleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApartmentRuleApplication.class, args);
	}

}

