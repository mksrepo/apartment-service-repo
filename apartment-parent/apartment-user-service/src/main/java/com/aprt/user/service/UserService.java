/*
 * ApplicationStarter.java
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.service;

import java.util.List;

import com.aprt.user.model.User;

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
public interface UserService {

	/**
	 * Method to create new user
	 * 
	 * @param User
	 *            userDetails
	 * @return UserModelBean userModelBean
	 */
	public User createUser(User userDetails);

	/**
	 * Method to get all user details
	 * 
	 * @return List<UserModelBean> modelList
	 */
	public List<User> getAllUsers();

	/**
	 * Method to delete user record by id
	 * 
	 * @param String
	 *            userId
	 */
	public void deleteUserById(String userId);

	/**
	 * Method to update user
	 * 
	 * @param User
	 *            userDetails
	 * @param String
	 *            userId
	 */
	public void updateUser(User userDetails, String userId);

	/**
	 * Method to return user data by selected userId
	 * 
	 * @param String
	 *            userId
	 * @return UserModelBean userModelBean
	 */
	public User findById(String userId);

}
