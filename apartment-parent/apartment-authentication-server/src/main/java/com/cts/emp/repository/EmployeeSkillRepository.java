package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.emp.model.EmployeeQualification;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeQualification, Integer>{

}
