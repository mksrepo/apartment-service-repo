/*
 * UserConstant.java
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.util;

/**
 * <h1>Application Starter</h1> This class is responsible for triggering Spring
 * Boot application by loading all resources and context.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
public class UserConstants {
	public static final String ENDPOINT_CREATE = "/save";
	public static final String ENDPOINT_GETUSERS = "/get";
	public static final String ENDPOINT_GETDETAILSBYID = "/userId/{userId}";
	public static final String ENDPOINT_DELETEBYID = "/delete/{userId}";
	public static final String ENDPOINT_UPDATE = "/update/{userId}";

	public static final String USER_ID = "user_Id";
	public static final String USER_PASSWORD = "user_Password";
	public static final String USER_NAME = "user_Name";
	public static final String USER_EMAIL = "user_Email";
	public static final String USER_MOBILE = "user_Mobile";
	public static final String USER_ROLE = "user_Role";
	public static final String USER_STATUS = "user_Status";
}