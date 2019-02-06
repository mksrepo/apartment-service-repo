/*
 * UserServiceImpl.java
 * 
 * Description: user service implementation class
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprt.user.model.User;
import com.aprt.user.entity.UserEntity;
import com.aprt.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>Application Starter</h1> This class is to provide implementation logic
 * for user service.
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User createUser(User userDetails) {
		ObjectMapper mapper = new ObjectMapper();
		UserEntity userModel = mapper.convertValue(userDetails, UserEntity.class);
		return mapper.convertValue(userRepo.save(userModel), User.class);

	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (UserEntity temp : userRepo.findAll()) {
			User details = mapper.convertValue(temp, User.class);
			list.add(details);

		}
		return list;

	}

	@Transactional
	@Override
	public void deleteUserById(String userId) {
		userRepo.updateDeleteFlag(userId);

	}

	@Transactional
	@Override
	public void updateUser(User userDetails, String userId) {
		userRepo.updateUser(userId, userDetails.getUserName(), userDetails.getUserPassword(),
				userDetails.getUserEmail(), userDetails.getUserMobile(), userDetails.getUserRole());
	}

	@Override
	public User findById(String userId) {
		ObjectMapper mapper = new ObjectMapper();
		User details = mapper.convertValue(userRepo.findOne(Integer.parseInt(userId)), User.class);
		return details;
	}

}
