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
package com.aprt.user.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprt.user.exception.UserCustomException;
import com.aprt.user.model.User;
import com.aprt.user.model.UserServiceResponse;
import com.aprt.user.service.UserService;
import com.aprt.user.util.UserConstants;
import com.aprt.util.AppConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <h1>Application Controller</h1> This class is responsible for controlling
 * user request.
 * <p>
 * <b>Note:</b> This class doesn't carries out any business logic implementation
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */

@RestController
@RequestMapping("userservice")
public class UserController {

	@Autowired
	UserService service;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * This method is to save User details
	 * 
	 * @param details
	 * @return
	 * @throws UserCustomException
	 */
	@ApiOperation(value = "Save User Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = UserServiceResponse.class),
			@ApiResponse(code = 400, message = "Validation Failure", response = UserServiceResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = UserServiceResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = UserServiceResponse.class) })
	@PostMapping(UserConstants.ENDPOINT_CREATE)
	public UserServiceResponse createUsers(@Valid @RequestBody User details) throws UserCustomException {
		UserServiceResponse responseBean = new UserServiceResponse();
		List<User> userList = new ArrayList<>();
		details = service.createUser(details);
		if (details != null) {
			userList.add(details);
			responseBean.setStatus_Code(AppConstants.STATUS_CODE);
			responseBean.setMessage(AppConstants.MESSAGE);
			responseBean.setUserList(userList);
			logger.info(AppConstants.SUCCESS);
		} else {
			logger.error(AppConstants.ERROR_CODE);
			throw new UserCustomException("Record is not found");
		}
		return responseBean;
	}

	/**
	 * End-point to get all details of userService
	 * 
	 * @return UserModelBean list
	 */
	@GetMapping(UserConstants.ENDPOINT_GETUSERS)
	public List<User> getAllUser() {
		List<User> user = service.getAllUsers();
		if (!user.isEmpty()) {
			logger.info(AppConstants.SUCCESS);

		} else {
			logger.error(AppConstants.ERROR_CODE);
			throw new UserCustomException("Record is not found");
		}
		return user;
	}

	/**
	 * End-point to get user by ID
	 * 
	 * @param userId
	 * @return UserModelBean ResponseEntity
	 * @throws UserCustomException
	 */
	@GetMapping(UserConstants.ENDPOINT_GETDETAILSBYID)
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) throws UserCustomException {
		System.out.println("Fetching user by userId " + userId);
		User details = service.findById(userId);
		if (details == null) {
			throw new UserCustomException(AppConstants.ERROR_CODE);
		}
		return new ResponseEntity<User>(details, HttpStatus.OK);
	}

	/**
	 * End-Point to delete user by userId
	 * 
	 * @param String
	 *            userId
	 * @return String
	 */
	@PutMapping(UserConstants.ENDPOINT_DELETEBYID)
	public String delete(@PathVariable("userId") String userId) {
		service.deleteUserById(userId);
		return "User Deleted";

	}

	@PutMapping(UserConstants.ENDPOINT_UPDATE)
	public void updateUser(@RequestBody User userBean, @PathVariable("userId") String userId) {
		service.updateUser(userBean, userId);
		logger.info(AppConstants.SUCCESS);
	}

}
