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
package com.aprt.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aprt.user.entity.UserEntity;

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
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Modifying
	@Query(value = "UPDATE UserModelEntity p SET p.userStatus  = 'Y' WHERE p.userId = :userId", nativeQuery = true)
	void updateDeleteFlag(@Param("userId") String userId);

	@Modifying
	@Query(value = "UPDATE UserModelEntity p SET p.userName  = :userName ,p.userPassword  = :userPassword ,p.userEmail  = :userEmail ,p.userMobile  = :userMobile,p.userRole  = :userRole  WHERE p.userId = :userId", nativeQuery = true)
	void updateUser(@Param("userId") String userId, @Param("userName") String userName,
			@Param("userPassword") String userPassword, @Param("userEmail") String userEmail,
			@Param("userMobile") String userMobile, @Param("userRole") String userRole);

	@Override
	@Query(value = "SELECT p FROM UserModelEntity p WHERE userStatus='N'", nativeQuery = true)
	public List<UserEntity> findAll();

	@Query(value = "SELECT p FROM UserModelEntity p WHERE p.userId = :userId and userStatus='N'", nativeQuery = true)
	public UserEntity findOne(@Param("userId") Integer userId);

}
