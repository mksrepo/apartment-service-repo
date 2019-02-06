/*
 * UserCustomException.java
 * 
 * Description: custom exception
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.exception;

/**
 * <h1>Application Starter</h1>
 * This class is responsible for custom exception.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
@SuppressWarnings("serial")
public class UserCustomException extends RuntimeException{
	public UserCustomException(String msg){
		super(msg);
		
	}
}
