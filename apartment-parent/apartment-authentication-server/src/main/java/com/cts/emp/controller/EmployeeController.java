package com.cts.emp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emp.model.CityEntity;
import com.cts.emp.model.CountryEntity;
import com.cts.emp.model.Employee;
import com.cts.emp.model.StateEntity;
import com.cts.emp.service.EmployeeServiceIntrfc;
import com.cts.general.EmployeeGeneral;
import com.cts.general.GeneralResponse;
import com.cts.general.LoginGeneral;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/employeeGeneral")
public class EmployeeController {

	@Autowired
	private EmployeeServiceIntrfc empservice;

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Value("${custom.message}")
	private String message;

	@CrossOrigin
	@RequestMapping(value = "/getCountries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CountryEntity>> getAllCountries(HttpServletRequest request) {
		List<CountryEntity> countryList = new ArrayList<CountryEntity>();
		System.out.println("Message from yml: " + message);
		countryList = (List<CountryEntity>) empservice.fetchAllCountry();
		return new ResponseEntity<List<CountryEntity>>(countryList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/getStateByCountryID", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StateEntity>> getStateByCountryID(HttpServletRequest request) {
		List<StateEntity> stateList_all = new ArrayList<StateEntity>();

		String countryid = request.getParameter("countryID");

		stateList_all = (List<StateEntity>) empservice.fetchAllState();
		List<StateEntity> stateList = stateList_all.stream()
				.filter(n -> n.getCountryId().getCid().equals(Integer.parseInt(countryid)))
				.collect(Collectors.toList());

		return new ResponseEntity<List<StateEntity>>(stateList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/getCityByStateID", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityEntity>> getCityByStateID(HttpServletRequest request) {
		List<CityEntity> cityList_all = new ArrayList<CityEntity>();

		String stateid = request.getParameter("stateID");

		cityList_all = (List<CityEntity>) empservice.fetchAllCity();
		List<CityEntity> cityList = cityList_all.stream()
				.filter(n -> n.getStateId().getStateid().equals(Integer.parseInt(stateid)))
				.collect(Collectors.toList());

		return new ResponseEntity<List<CityEntity>>(cityList, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<GeneralResponse> checkLogin(@RequestBody LoginGeneral login, HttpServletRequest request) {

		// Employee
		// emp=(Employee)empservice.checkLogin(login.getUsername(),passwordEncoder.encode(login.getPassword()));

		Employee emp = (Employee) empservice.checkLogin(login.getUsername(), login.getPassword());

		String resp = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();

		GeneralResponse gr = new GeneralResponse();
		if (emp != null && emp.getEid() != null && emp.getEid() > 0) {
			String encodedPassword = emp.getEpassword();
			// Boolean b=passwordEncoder.matches(login.getPassword(), encodedPassword);
			Boolean b = true;
			if (b) {
				gr.setStatuscode("100");
				gr.setStatus("SUCCESS");

				String jwtToken = Jwts.builder().setSubject("LoginAuthentication").claim("roles", "user")
						.claim("username", login.getUsername()).claim("scope", "self groups/admins")
						.claim("code", "S1001").setIssuedAt(new Date()).setId(login.getUsername() + login.getUsername())
						.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

				gr.setAuthtoken(jwtToken);
			} else {
				gr.setStatuscode("200");
				gr.setStatus("Password Not Matched");
			}
		} else {
			gr.setStatuscode("200");
			gr.setStatus("FAILED");
		}

		return new ResponseEntity<GeneralResponse>(gr, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createNewUser(@RequestBody EmployeeGeneral emp) {
		String resp = "";
		System.out.println("Request Data: " + emp.getEname());
		// empservice.createEmployee(emp);
		if (emp != null && emp.getEname() != null && emp.getEname().isEmpty() == false) {
			Employee empobj = new Employee();

			empobj.setEname(emp.getEname());
			empobj.setEaddr(emp.getEaddr());

			CountryEntity cn = new CountryEntity();
			cn.setCid(emp.getEcountryid());
			empobj.setEcountryid(cn);

			StateEntity se = new StateEntity();
			se.setStateid(emp.getEstateid());
			empobj.setEstateid(se);

			CityEntity ce = new CityEntity();
			ce.setCityid(emp.getEcityid());
			empobj.setEcityid(ce);

			empobj.setEdob(emp.getEdob());
			empobj.setEcontact(emp.getEcontact());
			empobj.setEgender(emp.getEgender());
			empobj.setEusername(emp.getEusername());
			empobj.setEpassword(emp.getEpassword());
			// empobj.setEpassword(passwordEncoder.encode(emp.getEpassword()));
			if (emp.getEid() != null && emp.getEid() > 0) {
				empobj.setEid(emp.getEid());
			}
			empservice.createEmployee(empobj);

		}
		resp = "Successfully Done";
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@RequestMapping("/test")
	public String testFunction() {

		return "Hello";
	}
}
