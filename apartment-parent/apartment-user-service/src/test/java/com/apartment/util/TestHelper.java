package com.apartment.util;

import java.util.ArrayList;
import java.util.List;

import com.apartment.user.entity.UserEntity;
import com.apartment.user.model.User;
import com.apartment.user.entity.UserKey;

public class TestHelper {

	public static UserEntity getEntityUserObj(){
		
	UserEntity userEntity=new UserEntity("1", "suryacitm@gmail.com", "9123323782", "dev");
	return userEntity;

}
	public static User getUserObj(){
		
		User user=new User("1", "suryacitm@gmail.com", "9123323782", "dev");
		UserKey userkey=new UserKey();
		userkey.setUserName("Surya");
		userkey.setUserStatus("N");
		user.setUserKey(userkey);
		return user;

	}
	public static List<User> getAllUser(){
		List<User> list=new ArrayList<>();
		User user=new User("1", "suryacitm@gmail.com", "9123323782", "dev");
		list.add(user);
		return list;
		
		
	}
	public static List<UserEntity> getAllUserObj(){
		List<UserEntity> list=new ArrayList<>();
		UserEntity userEntity=new UserEntity("1", "suryacitm@gmail.com", "9123323782", "dev");
		list.add(userEntity);
		return list;
		
		
	}
}