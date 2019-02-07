/*
 * UserConstant.java
 * 
 * Description: application constants
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Application Starter</h1> This class is responsible to provide general
 * purpose application constants.
 * <p>
 * <b>Note:</b> This class doesn't carries-out any business logic
 *
 * @author Mrinmay Santra
 * @version 1.0
 * @since 2019-01-34
 */
public class AppConstants {

	// Entity - Constants
	public static final String STATUS_CODE = "200";
	public static final String MESSAGE = "Your Record Is Successfully Created";

	public static final String SUCCESS = "Successful";
	public static final String ERROR_CODE = "Record Not Found";

	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

}