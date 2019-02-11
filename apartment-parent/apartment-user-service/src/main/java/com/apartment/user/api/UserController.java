package com.apartment.user.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.user.exception.UserCustomException;
import com.apartment.user.model.User;
import com.apartment.user.model.UserServiceResponse;
import com.apartment.user.model.ValidateUserResponseBean;
import com.apartment.user.service.UserService;
import com.apartment.user.util.UserConstants;
import com.apartment.util.AppConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("userservice")
public class UserController {

	@Autowired
	UserService service;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * This method is to save User details
	 * 
	 * @param userDetails
	 * @return
	 * @throws UserCustomException
	 */
	@ApiOperation(value = "Save User details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = UserServiceResponse.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = UserServiceResponse.class),
		@ApiResponse(code = 404, message = "Not Found", response = UserServiceResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = UserServiceResponse.class) 
	})
	@PostMapping(UserConstants.ENDPOINT_CREATE)
	public UserServiceResponse createUser(@Valid @RequestBody User userDetails) throws UserCustomException {
		UserServiceResponse responseBean = new UserServiceResponse();
		List<User> userList = new ArrayList<>();
		userDetails = service.createUser(userDetails);
		if (userDetails != null) {
			userList.add(userDetails);
			responseBean.setStatusCode(AppConstants.STATUS_CODE);
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
	 * @return UserModelBean list
	 */
	@ApiOperation(value = "Get all user details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = User.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = User.class),
		@ApiResponse(code = 404, message = "Not Found", response = User.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = User.class) 
	})
	@GetMapping(UserConstants.ENDPOINT_GETUSERS)
	public List<User> getAllUsers() {
		List<User> user = service.getAllUsers();
		if (!user.isEmpty())
			logger.info(AppConstants.SUCCESS);
		else {
			logger.error(AppConstants.ERROR_CODE);
			throw new UserCustomException("No user found!");
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
	@ApiOperation(value = "Get user details by user-name")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = User.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = User.class),
		@ApiResponse(code = 404, message = "Not Found", response = User.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = User.class) 
	})
	@GetMapping(UserConstants.ENDPOINT_GETDETAILS_BY_USERNAME)
	public ResponseEntity<User> getUserByUserName(@PathVariable("userName") String userName)
			throws UserCustomException {
		User details = service.findByUserName(userName);
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
	@ApiOperation(value = "Delete user details by user-name")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = String.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = String.class),
		@ApiResponse(code = 404, message = "Not Found", response = String.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) 
	})
	@PutMapping(UserConstants.ENDPOINT_DELETE_BY_USERNAME)
	public String delete(@PathVariable("userName") String userName) {
		service.deleteUserByUserName(userName);
		return "User Deleted";
	}

	/**
	 * @param userBean
	 * @param userId
	 */
	@ApiOperation(value = "Update user details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = User.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = User.class),
		@ApiResponse(code = 404, message = "Not Found", response = User.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = User.class) 
	})
	@PutMapping(UserConstants.ENDPOINT_UPDATE)
	public void updateUser(@RequestBody User userBean) {
		service.updateUser(userBean);
		logger.info(AppConstants.SUCCESS);
	}

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "Validate user details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = ValidateUserResponseBean.class),
		@ApiResponse(code = 400, message = "Validation Failure", response = ValidateUserResponseBean.class),
		@ApiResponse(code = 404, message = "Not Found", response = ValidateUserResponseBean.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ValidateUserResponseBean.class) 
	})
	@PostMapping(UserConstants.ENDPOINT_VALIDATION)
	public ResponseEntity<ValidateUserResponseBean> validateUser(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {

		// Validating user credential
		User userDetails = service.validateUser(userName, password);

		// Extracting validation info
		ValidateUserResponseBean validateUserResponse = new ValidateUserResponseBean();
		if (userDetails != null && !StringUtils.isEmpty(userDetails.getUserRole())) {
			validateUserResponse = new ValidateUserResponseBean(true, userDetails.getUserRole());
			validateUserResponse.setUser(service.findByUserName(userName));
		}

		// Returning response
		return new ResponseEntity<ValidateUserResponseBean>(validateUserResponse, HttpStatus.OK);

	}

}
