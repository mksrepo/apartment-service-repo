package com.apartment.user.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apartment.user.util.UserConstants;

@Entity
@Table(name = UserConstants.USER_ENTITY)
public class UserEntity {

	@EmbeddedId
	private UserKey userKey;

	@Column(name = UserConstants.USER_PASSWORD)
	private String userPassword;

	@Column(name = UserConstants.USER_EMAIL)
	private String userEmail;

	@Column(name = UserConstants.USER_MOBILE)
	private String userMobile;

	@Column(name = UserConstants.USER_ROLE)
	private String userRole;

	public UserEntity() {

	}

	public UserEntity(String userPassword, String userEmail, String userMobile, String userRole) {
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
		return "UserModel [userPassword=" + userPassword + ", userKey=" + userKey + ", userEmail=" + userEmail
				+ ", userMobile=" + userMobile + ", userRole=" + userRole + "]";
	}

}
