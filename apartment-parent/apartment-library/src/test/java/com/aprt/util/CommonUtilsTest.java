/*
 * CommonUtilsTest.java
 * 
 * Description: test class for common utility provider
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190104	Mrinmay Santra		Initial Version
 */
package com.aprt.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <h1>Unit Test Cases</h1>
 * This class is responsible for providing test-cases of common utilities
 * 
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Mrinmay Santra
 * @version 1.0
 * @since 2019-01-34
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonUtilsTest {

	/**
	 * This method is responsible to null checking of any given object
	 * 
	 * @author Mrinmay Santra
	 * @param object
	 * @return nothing
	 * @exception nothing
	 */
	@Test
	public void testIsEmptyObject_positive() {

		// assert null object
		assertTrue(CommonUtils.isEmptyObject(null));
	}
	
	/**
	 * This method is responsible to not-null checking of any given object
	 * 
	 * @author Mrinmay Santra
	 * @param object
	 * @return nothing
	 * @exception nothing
	 */
	@Test
	public void testIsEmptyObject_negative() {

		// Asserting null object
		assertFalse(CommonUtils.isEmptyObject(new Object()));
	}
}
