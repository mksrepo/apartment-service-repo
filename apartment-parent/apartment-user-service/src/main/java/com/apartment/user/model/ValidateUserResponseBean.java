package com.apartment.user.model;

public class ValidateUserResponseBean {
	private User user;
	private boolean isValid;
	private String userRole;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
