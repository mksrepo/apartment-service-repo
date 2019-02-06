/*
 * ApplicationStarter.java
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Application Starter</h1>
 * This class is responsible for triggering Spring
 * Boot application by loading all resources and context.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
@SpringBootApplication
public class ApplicationStarter {

	/**
	 * This method is the starting point of the application.
	 * 
	 * @author Surya Yadav
	 * @param args
	 * @return Nothing
	 * @exception Nothing
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}
