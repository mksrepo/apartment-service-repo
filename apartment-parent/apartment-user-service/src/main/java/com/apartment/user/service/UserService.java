package com.apartment.user.service;

import java.util.List;

import com.apartment.user.model.User;

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
	public void deleteUserByUserName(String userName);

	/**
	 * Method to update user
	 * 
	 * @param User
	 *            userDetails
	 * @param String
	 *            userId
	 */
	public void updateUser(User userDetails);

	/**
	 * Method to return user data by selected userId
	 * 
	 * @param String
	 *            userId
	 * @return UserModelBean userModelBean
	 */
	public User findByUserName(String userName);

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public User validateUser(String userName, String password);

}
