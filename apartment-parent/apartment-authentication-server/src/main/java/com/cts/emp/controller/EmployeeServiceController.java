package com.cts.emp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emp.model.Employee;
import com.cts.emp.model.EmployeeQualification;
import com.cts.emp.service.EmployeeServiceIntrfc;

@RestController
@RequestMapping("/employeeService")
public class EmployeeServiceController {

	@Autowired
	private EmployeeServiceIntrfc empservice;
	
	
	@CrossOrigin
	@RequestMapping(value="/searchEmployee",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes = "application/json")
	public ResponseEntity<List<Employee>> searchEmployee(HttpServletRequest request)
	{
		List<Employee> empList=new ArrayList<Employee>();
		List<Employee> empList_filtered=new ArrayList<Employee>();
		String srctext=request.getParameter("srctxt");
		empList=(List<Employee>)empservice.getAllEmployees();
		if(empList!=null && empList.size()>0)
		{
			
			
			
			empList_filtered=empList.stream().filter(n->n.getEname().startsWith(srctext)||
					                                    n.getEcontact().equals(srctext)||
					                                    n.getEaddr().contains(srctext)||
					                                    n.getEusername().contains(srctext)
					                                    
					                                 ).collect(Collectors.toList());
		}
		
		return new ResponseEntity<List<Employee>>(empList_filtered,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getEmployeeById/{eid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") Integer empid,HttpServletRequest request)
	{
		Employee empobj=new Employee();
		
		if(empid!=null && empid>0)
		{
			empobj=empservice.getEmployeeById(empid);
			//System.out.println("Emp data: "+empobj.getEname()+" / "+empobj.getEaddr()+" / "+empobj.getEcontact());
			return new ResponseEntity<Employee>(empobj,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(new Employee(),HttpStatus.OK);
		}
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/getAllEmployees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployees(HttpServletRequest request)
	{
		Employee emp=new Employee();
		List<Employee> empList=new ArrayList<Employee>();
		
		empList=(List<Employee>)empservice.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/createEmployeeSkill", method=RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<String> createEmployeeSkills(@RequestBody EmployeeQualification eqf)
		{
		String resp="";
		
		empservice.createEmployeeSkill(eqf);
		
		resp="Successfully Done";
		return new ResponseEntity<String>(resp,HttpStatus.OK);
		
		 
			
		}
	
	@CrossOrigin
	@RequestMapping(value="/getEmployeeSkillByID/{eid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes = "application/json")
	public ResponseEntity<EmployeeQualification> getEmployeeSkillByID(@PathVariable("eid") Integer empid,HttpServletRequest request)
	{
		EmployeeQualification eqf=empservice.getEmployeeQualificationByID(empid);
		
		
		
		return new ResponseEntity<EmployeeQualification>(eqf,HttpStatus.OK);
	}
	
		
	@RequestMapping("/test")
	public String testApp()
	{
		return "Hello";
	}
}
