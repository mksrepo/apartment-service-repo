package com.cog.apartment.exception;

public class ApartmentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8672114887895194875L;

	public ApartmentException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public ApartmentException(Object obj) {
		super();
		this.obj = obj;
	}

	private String errorCode;
	private String errorMsg;
	private Object obj;

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

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
