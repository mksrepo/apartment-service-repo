package com.cog.apartment.exception;

public enum ErrorCode {	
	
	AptNotFound("ANF","Apartment Not Found"),
	AptAddEx("APTADDEX","Exception occured while trying to add exception"),
	UnitTypAddEx("UTYPEX","Exception occured while trying to add Unit Type"),
	AptInternalErr("INTERR","Unknon Exception"),
	UpdtErr("UPDE","Data is not saved successfully");
	
	
	private final String code;
	private final String msg;

	public String getCode() {
		return code;
	}

	ErrorCode(String code,String msg) {		
		this.code = code;
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}	
	
}
