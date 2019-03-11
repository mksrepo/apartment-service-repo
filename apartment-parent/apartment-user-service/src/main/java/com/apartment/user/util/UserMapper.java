package com.apartment.user.util;

import com.apartment.user.entity.UserEntity;
import com.apartment.user.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMapper {
	public static User entityToDto(UserEntity entity) {
		return new ObjectMapper().convertValue(entity, User.class);
	}
}
