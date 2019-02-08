package com.apartment.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(UserCustomException.class)
	public ResponseEntity<?> handleCustomException(UserCustomException ex) {
		ErrorDetails errorDetails = new ErrorDetails("1", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
