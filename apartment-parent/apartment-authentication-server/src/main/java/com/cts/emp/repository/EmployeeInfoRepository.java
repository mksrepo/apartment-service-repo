package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.model.Employee;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<Employee, Integer>{

}
