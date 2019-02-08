package com.apartment.user.model;

import java.util.List;

public class UserServiceResponse {

	private String status_Code;
	private String message;
	private List<User> userList;

	public UserServiceResponse() {
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
