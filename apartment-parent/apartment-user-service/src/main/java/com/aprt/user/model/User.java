package com.aprt.user.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.aprt.user.entity.UserKey;

@SuppressWarnings("deprecation")
public class User {

	private UserKey userKey;

	@NotNull
	private String userPassword;

	@Email
	private String userEmail;
	@NotEmpty
	private String userMobile;
	@NotNull
	private String userRole;

	public User() {
	}

	public User(String userPassword, String userEmail, String userMobile, String userRole) {
		super();
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userRole = userRole;
	}

	public UserKey getUserKey() {
		return userKey;
	}

	public void setUserKey(UserKey userKey) {
		this.userKey = userKey;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserModelDetails [userkey=" + userKey + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userMobile=" + userMobile + ", userRole=" + userRole + "]";
	}

}
