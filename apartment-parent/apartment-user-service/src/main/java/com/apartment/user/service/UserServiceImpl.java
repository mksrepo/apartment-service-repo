package com.apartment.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.user.entity.UserEntity;
import com.apartment.user.model.User;
import com.apartment.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public void deleteUserByUserName(String userName) {
		String userStatus = "Y" + new Date().getTime();
		userRepo.updateDeleteFlag(userName, userStatus);

	}

	@Transactional
	@Override
	public void updateUser(User userDetails) {
		userRepo.updateUser(userDetails.getUserKey().getUserName(), userDetails.getUserPassword(),
				userDetails.getUserEmail(), userDetails.getUserMobile(), userDetails.getUserRole());
	}

	@Override
	public User findByUserName(String userName) {
		ObjectMapper mapper = new ObjectMapper();
		User details = mapper.convertValue(userRepo.findOne(userName), User.class);
		return details;
	}

	@Override
	public User validateUser(String userName, String password) {
		ObjectMapper mapper = new ObjectMapper();
		User details = mapper.convertValue(userRepo.findByCredential(userName, password), User.class);
		return details;

	}

}
