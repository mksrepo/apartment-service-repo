package com.apartmentrule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apartmentrule.constant.ApartmentRuleConstants;

/**
 * This class manage all runtime exception for Apartment Rule
 * @author 748152
 *
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler{
	
	/**
	 * this method give custom error massage to user for any exception
	 * @param ApartmentRuleCustomException ex
	 * @return ResponseEntity ErrorDetails
	 */
	@ExceptionHandler(ApartmentRuleCustomException.class)
	public ResponseEntity<?>  handleNotFoundException(ApartmentRuleCustomException ex) {
		ErrorDetails responseMsg = new ErrorDetails(ApartmentRuleConstants.ERROR_CODE,ex.getMessage());
		return new ResponseEntity<ErrorDetails>(responseMsg,HttpStatus.NOT_FOUND);
	}



}
