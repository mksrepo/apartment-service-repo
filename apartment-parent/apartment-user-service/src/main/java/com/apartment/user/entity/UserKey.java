package com.apartment.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.apartment.user.util.UserConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class UserKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = UserConstants.USER_NAME)
	private String userName;

	@JsonIgnore
	@Column(name = UserConstants.USER_STATUS)
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