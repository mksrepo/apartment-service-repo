package com.apartment.user.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.user.model.User;
import com.apartment.user.repository.UserRepository;
import com.apartment.user.util.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return UserMapper.entityToDto(userRepo.save(UserMapper.dtoToEntity(user)));
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		return Optional.ofNullable(userRepo.findAll().stream().map(UserMapper::entityToDto).collect(Collectors.toList()));
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
