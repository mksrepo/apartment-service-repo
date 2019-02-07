package com.aprt.user.util;

public class UserConstants {

	public static final String USER_ENTITY = "UserEntity";

	public static final String ENDPOINT_CREATE = "/save";
	public static final String ENDPOINT_GETUSERS = "/getAll";
	public static final String ENDPOINT_GETDETAILS_BY_USERNAME = "/get/{userName}";
	public static final String ENDPOINT_DELETE_BY_USERNAME = "/delete/{userName}";
	public static final String ENDPOINT_UPDATE = "/update";
	public static final String ENDPOINT_VALIDATION = "/validation/{userName}/{password}";

	public static final String USER_PASSWORD = "user_Password";
	public static final String USER_NAME = "user_Name";
	public static final String USER_EMAIL = "user_Email";
	public static final String USER_MOBILE = "user_Mobile";
	public static final String USER_ROLE = "user_Role";
	public static final String USER_STATUS = "user_Status";
}