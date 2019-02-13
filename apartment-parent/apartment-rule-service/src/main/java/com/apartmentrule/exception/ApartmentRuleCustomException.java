package com.apartmentrule.exception;

/**
 * this class has implementation of runtime exception
 * @author 748152
 *
 */
@SuppressWarnings("serial")
public class ApartmentRuleCustomException extends RuntimeException{
	
	public ApartmentRuleCustomException(String msg) {
		super(msg);
	}

}
