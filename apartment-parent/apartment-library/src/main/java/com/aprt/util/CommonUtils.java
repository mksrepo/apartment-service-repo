/*
 * CommonUtils.java
 * 
 * Description: common utility provider
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190104	Mrinmay Santra		Initial Version
 */
package com.aprt.util;

/**
 * <h1>Utility Provider</h1>
 * This class is responsible for providing common utilities
 * 
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Mrinmay Santra
 * @version 1.0
 * @since 2019-01-34
 */
public class CommonUtils {
	
	/**
	 * This method is responsible to check null of any given object
	 * 
	 * @author Mrinmay Santra
	 * @param object
	 * @return nothing
	 * @exception nothing
	 */
	public static boolean isEmptyObject(Object object) {
		
		// Null checking and returning result 
		return object == null;
	}
}
