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
package com.aprt.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
@RestControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(UserCustomException.class)
    public ResponseEntity<?> handleCustomException(UserCustomException ex) {
		ErrorDetails errorDetails = new ErrorDetails("1",ex.getMessage());
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    } 

}
