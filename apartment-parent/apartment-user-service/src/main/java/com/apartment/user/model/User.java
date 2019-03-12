package com.apartment.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apartment.user.entity.UserKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User implements AutoCloseable{

	private static final Logger logger = LoggerFactory.getLogger(User.class);
	private UserKey userKey;

	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
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

	@Override
	public void close() throws Exception {
		logger.error("Internal Exception :: Occured in User manipulation.");
	}

}
