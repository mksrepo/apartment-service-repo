package com.apartment.user.exception;

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
