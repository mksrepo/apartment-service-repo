package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.model.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer>{

}
