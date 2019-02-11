package com.apartment.user.model;

import java.util.List;

public class UserServiceResponse {

	private String statusCode;
	private String message;
	private List<User> userList;

	public UserServiceResponse() {
		super();
	}

	public UserServiceResponse(String statusCode, String message, List<User> userList) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.userList = userList;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
