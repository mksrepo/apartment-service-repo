package com.cts.emp.service;

import java.util.List;

import com.cts.emp.model.AdminUser;
import com.cts.emp.model.CityEntity;
import com.cts.emp.model.CountryEntity;
import com.cts.emp.model.Employee;
import com.cts.emp.model.EmployeeQualification;
import com.cts.emp.model.StateEntity;


public interface EmployeeServiceIntrfc {
public List<CountryEntity> fetchAllCountry();
public List<StateEntity> fetchAllState();
public List<CityEntity> fetchAllCity();
public List<AdminUser> getAllAdminUser();
public void createEmployee(Employee emp);
public void createEmployeeSkill(EmployeeQualification eqf);
public List<Employee> getAllEmployees();
public Employee getEmployeeById(Integer eid);
public EmployeeQualification getEmployeeQualificationByID(Integer empid);

public Employee checkLogin(String uname,String pwd);
}
