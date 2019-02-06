/*
 * User.java
 * 
 * Description: User POJO
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <h1>Application Starter</h1> This class is responsible to provide common
 * properties of user.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
@SuppressWarnings("deprecation")
public class User {

	private Integer userId;

	@NotNull
	private String userPassword;
	@NotNull(message = "name must not be blank!")
	private String userName;
	@Email
	private String userEmail;
	@NotEmpty
	private String userMobile;
	@NotNull
	private String userRole;

	public User() {
	}

	public User(Integer userId, String userPassword, String userName, String userEmail, String userMobile,
			String userRole) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "UserModelDetails [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userMobile=" + userMobile + ", userRole=" + userRole + "]";
	}

}
