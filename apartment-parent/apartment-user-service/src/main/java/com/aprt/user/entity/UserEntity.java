/*
 * UserEntity.java
 * 
 * Description: User entity
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aprt.user.util.UserConstants;
import com.aprt.util.AppConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <h1>User Entity</h1> This class is the presentation of User entity.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-31
 */
@Entity
@Table(name = AppConstants.USER_ENTITY)
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = UserConstants.USER_ID)
	private Integer userId;

	@Column(name = UserConstants.USER_PASSWORD)
	private String userPassword;

	@Column(name = UserConstants.USER_NAME)
	private String userName;

	@Column(name = UserConstants.USER_EMAIL)
	private String userEmail;

	@Column(name = UserConstants.USER_MOBILE)
	private String userMobile;

	@Column(name = UserConstants.USER_ROLE)
	private String userRole;

	@JsonIgnore
	@Column(name = UserConstants.USER_STATUS, columnDefinition = "Varchar2(5) default 'N'")
	private String userStatus = "N";

	public UserEntity() {

	}

	public UserEntity(Integer userId, String userPassword, String userName, String userEmail, String userMobile,
			String userRole, String userStatus) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userRole = userRole;
		this.userStatus = userStatus;
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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userMobile=" + userMobile + ", userRole=" + userRole + ", userStatus="
				+ userStatus + "]";
	}

}
