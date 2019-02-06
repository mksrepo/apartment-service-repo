/*
 * ErrorDetails.java
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.exception;

/**
 * <h1>Error POJO</h1> This class is responsible to define error properties.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-31
 */
public class ErrorDetails {

	private String errorCode;
	private String errorMsg;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public ErrorDetails(String errorCode2, String errorMsg2, String description) {
		this.errorCode = errorCode2;
		this.errorMsg = errorMsg2;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
