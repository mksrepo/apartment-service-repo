package com.apartment.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apartment.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Modifying
	@Query(value = "UPDATE UserEntity p SET p.userKey.userStatus  = :userStatus WHERE p.userKey.userName = :userName and p.userKey.userStatus='N'")
	void updateDeleteFlag(@Param("userName") String userName, @Param("userStatus") String userStatus);

	@Modifying
	@Query(value = "UPDATE UserEntity p SET p.userKey.userName  =:userName, p.userPassword  =:userPassword, p.userEmail =:userEmail, p.userMobile =:userMobile, p.userRole  =:userRole  WHERE p.userKey.userName =:userName")
	void updateUser(@Param("userName") String userName, @Param("userPassword") String userPassword,
			@Param("userEmail") String userEmail, @Param("userMobile") String userMobile,
			@Param("userRole") String userRole);

	@Override
	@Query(value = "SELECT p FROM UserEntity p WHERE p.userKey.userStatus='N'")
	public List<UserEntity> findAll();

	@Query(value = "SELECT p FROM UserEntity p WHERE p.userKey.userName = :userName and p.userKey.userStatus='N'")
	public UserEntity findOne(@Param("userName") String userName);

	@Query(value = "SELECT p FROM UserEntity p WHERE p.userKey.userName = :userName and p.userPassword = :userPassword and p.userKey.userStatus='N'")
	public UserEntity findByCredential(@Param("userName") String userId, @Param("userPassword") String userPassword);
}
