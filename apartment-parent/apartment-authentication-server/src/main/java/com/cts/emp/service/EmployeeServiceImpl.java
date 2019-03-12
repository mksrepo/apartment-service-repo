package com.cts.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.emp.model.AdminUser;
import com.cts.emp.model.CityEntity;
import com.cts.emp.model.CountryEntity;
import com.cts.emp.model.Employee;
import com.cts.emp.model.EmployeeQualification;
import com.cts.emp.model.StateEntity;
import com.cts.emp.repository.AdminUserRepository;
import com.cts.emp.repository.CityRepository;
import com.cts.emp.repository.CountryRepository;
import com.cts.emp.repository.EmployeeInfoRepository;
import com.cts.emp.repository.EmployeeSkillRepository;
import com.cts.emp.repository.StateRepository;

@Service("empservice")
public class EmployeeServiceImpl implements EmployeeServiceIntrfc{
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	
	@Autowired
	private CityRepository cityRepo;
	
	
	@Autowired
	private AdminUserRepository adminRepo;
	
	
	@Autowired
	private EmployeeInfoRepository empInfoRepo;
	
	
	@Autowired
	private EmployeeSkillRepository empSkillRepo;
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<CountryEntity> fetchAllCountry() {
		// TODO Auto-generated method stub
		return countryRepo.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<StateEntity> fetchAllState() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<CityEntity> fetchAllCity() {
		// TODO Auto-generated method stub
		return cityRepo.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AdminUser> getAllAdminUser() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empInfoRepo.save(emp);
	}

	@Override
	public Employee checkLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		List<Employee> empList=(List<Employee>)empInfoRepo.findAll();
		Employee emp=new Employee();
		if(empList!=null && empList.size()>0)
		{
			try
			{
			emp=empList.stream().filter(n-> n.getEusername().equals(uname))
	                            .findAny().get();
			}
			catch(Exception w)
			{
				emp=new Employee();
			}
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empInfoRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer eid) {
		// TODO Auto-generated method stub
		Employee emp=(Employee)empInfoRepo.getOne(eid);
		System.out.println("Emp data: "+emp.getEname()+" / "+emp.getEaddr()+" / "+emp.getEcontact());
		return emp;
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void createEmployeeSkill(EmployeeQualification eqf) {
		// TODO Auto-generated method stub
		empSkillRepo.save(eqf);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public EmployeeQualification getEmployeeQualificationByID(Integer empid) {
		// TODO Auto-generated method stub
		EmployeeQualification eqf=new EmployeeQualification();
		List<EmployeeQualification> qfList=(List<EmployeeQualification>)empSkillRepo.findAll();
		try
		{
			if(qfList!=null && qfList.size()>0)
			{
				eqf=qfList.stream().filter(n-> n.getEmpId().getEid().equals(empid))
	                    .findAny().get();
			}
		}
		catch(Exception w)
		{
			eqf=new EmployeeQualification();
		}
		return eqf;
	}

}
