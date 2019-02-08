package com.apartment.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppConstants {

	// Entity - Constants
	public static final String STATUS_CODE = "200";
	public static final String MESSAGE = "Your Record Is Successfully Created";

	public static final String SUCCESS = "Successful";
	public static final String ERROR_CODE = "Record Not Found";

	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

}