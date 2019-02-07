package com.aprt.user.model;

public class ValidateUserResponseBean {
	private boolean isValid;
	private String userRole;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public ValidateUserResponseBean(boolean isValid, String userRole) {
		super();
		this.isValid = isValid;
		this.userRole = userRole;
	}

	public ValidateUserResponseBean() {
	}
}
