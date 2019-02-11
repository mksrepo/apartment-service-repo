package com.apartment.user.util;

public class UserConstants {

	public static final String USER_ENTITY = "UserEntity";

	public static final String ENDPOINT_CREATE = "/saveUser";
	public static final String ENDPOINT_GETUSERS = "/getAllUsers";
	public static final String ENDPOINT_GETDETAILS_BY_USERNAME = "/getUser/{userName}";
	public static final String ENDPOINT_DELETE_BY_USERNAME = "/deleteUser/{userName}";
	public static final String ENDPOINT_UPDATE = "/updateUser";
	public static final String ENDPOINT_VALIDATION = "/validateUser/{userName}/{password}";

	public static final String USER_PASSWORD = "user_Password";
	public static final String USER_NAME = "user_Name";
	public static final String USER_EMAIL = "user_Email";
	public static final String USER_MOBILE = "user_Mobile";
	public static final String USER_ROLE = "user_Role";
	public static final String USER_STATUS = "user_Status";
}