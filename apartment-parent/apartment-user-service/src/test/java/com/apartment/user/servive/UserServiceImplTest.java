package com.apartment.user.servive;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.apartment.ApartmentUserServiceTest;
import com.apartment.user.entity.UserEntity;
import com.apartment.user.model.User;
import com.apartment.user.repository.UserRepository;
import com.apartment.user.service.UserService;
import com.apartment.user.service.UserServiceImpl;
import com.apartment.util.TestHelper;

public class UserServiceImplTest extends ApartmentUserServiceTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	public void testCreateUser() {
		UserEntity userEntity = TestHelper.getEntityUserObj();
		User user = TestHelper.getUserObj();
		Mockito.when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
		User details1 = userServiceImpl.createUser(user);
		assertEquals("suryacitm@gmail.com", details1.getUserEmail());

	}

	@Test
	public void testGetAllUsers() {
		List<UserEntity> userEntity = TestHelper.getAllUserObj();
		Mockito.when(userRepository.findAll()).thenReturn(userEntity);
		List<User> details1 = userServiceImpl.getAllUsers();
		assertEquals("1", details1.get(0).getUserPassword());
		assertEquals("suryacitm@gmail.com", details1.get(0).getUserEmail());
		assertEquals("9123323782", details1.get(0).getUserMobile());
		assertEquals("dev", details1.get(0).getUserRole());

	}

	@Test
	public void testFindUserByName() {
		String userName = "Surya";
		UserEntity userEntity = TestHelper.getEntityUserObj();
		Mockito.when(userRepository.findOne(userName)).thenReturn(userEntity);
		User details1 = userServiceImpl.findByUserName(userName);
		assertEquals("suryacitm@gmail.com", details1.getUserEmail());

	}

	@Test
	public void testValidateUser() {
		String userName = "Surya";
		String password = "123";
		UserEntity userEntity = TestHelper.getEntityUserObj();
		Mockito.when(userRepository.findByCredential(userName, password)).thenReturn(userEntity);
		User details1 = userServiceImpl.validateUser(userName, password);
		assertEquals("suryacitm@gmail.com", details1.getUserEmail());

	}

	@Test
	public void testUpdateUser() {
		User user = TestHelper.getUserObj();
		UserService userServiceImpl1 = Mockito.mock(UserServiceImpl.class);
		Mockito.doNothing().when(userServiceImpl1).updateUser(user);
		userServiceImpl.updateUser(user);

	}

	@Test
	public void testDeleteUserByUserName() {
		String userName = "Surya";
		// User user=Test_Helper.getUserObj();
		UserService userServiceImpl1 = Mockito.mock(UserServiceImpl.class);
		Mockito.doNothing().when(userServiceImpl1).deleteUserByUserName(userName);
		userServiceImpl.deleteUserByUserName(userName);

	}

}
