package com.cog.apartment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApartmentExceptionController {

	@ExceptionHandler(value = ApartmentException.class)
	public ResponseEntity<ResponseStatus> exceptionApartmentException(ApartmentException exception) {
		ResponseStatus msg = new ResponseStatus();
		msg.setCode(exception.getErrorCode());
		msg.setMsg(exception.getErrorMsg());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseStatus> unknownException(Exception exception) {
		ResponseStatus msg = new ResponseStatus();
		msg.setMsg(exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
	}

}
