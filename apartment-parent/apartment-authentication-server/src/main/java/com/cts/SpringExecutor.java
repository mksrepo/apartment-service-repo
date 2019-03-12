package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cts")
@EntityScan( basePackages = {"com.cts"} )
@EnableJpaRepositories("com.cts.emp.repository")
public class SpringExecutor {
	public static void main(String[] args)
	{
		SpringApplication.run(SpringExecutor.class, args);
	}
}
