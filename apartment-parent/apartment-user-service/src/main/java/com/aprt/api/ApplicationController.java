/*
 * ApplicationController.java
 * Copyright (c) 2019 Binary Total Solutions
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190104	Mrinmay Santra		Initial Version
 */
package com.aprt.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Application Controller</h1>
 * This class is responsible for controlling user request.
 * <p>
 * <b>Note:</b> This class doesn't carries out any business logic implementation
 *
 * @author Mrinmay Santra
 * @version 1.0
 * @since 2019-01-34
 */
@RestController
@RequestMapping("/")
public class ApplicationController {

	/**
	 * This method is to handle initial User request.
	 * 
	 * @author Mrinmay Santra
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getServiceInfo() {
		return "Welcome! To the Maven World ('_')";
	}

}
