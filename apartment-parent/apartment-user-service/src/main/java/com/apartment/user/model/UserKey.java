package com.apartment.user.model;

import javax.validation.constraints.NotNull;

public class UserKey {

	@NotNull(message = "Name must not be blank!")
	private String userName;

	private String userStatus = "N";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", userStatus=" + userStatus + "]";
	}

}