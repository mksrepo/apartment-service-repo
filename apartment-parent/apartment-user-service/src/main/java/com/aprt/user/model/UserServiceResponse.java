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
package com.aprt.user.model;

import java.util.List;

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
public class UserServiceResponse {
	
	private String status_Code;
	private String message;
	private List<User> userList;
	public UserServiceResponse(){
	super();
	}
	public UserServiceResponse(String status_Code, String message, List<User> userList) {
		super();
		this.status_Code = status_Code;
		this.message = message;
		this.userList = userList;
	}
	public String getStatus_Code() {
		return status_Code;
	}
	public void setStatus_Code(String status_Code) {
		this.status_Code = status_Code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
