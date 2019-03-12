package com.cts.emp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.cts.emp.model.CityEntity;
import com.cts.emp.model.CountryEntity;
import com.cts.emp.service.EmployeeServiceImpl;
import com.cts.emp.service.EmployeeServiceIntrfc;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



public class JwtAuthenticationFilter implements Filter{

	
	//@Autowired
	//private EmployeeServiceIntrfc empservice;
	
	private EmployeeServiceIntrfc empservice;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
	    final HttpServletResponse resp = (HttpServletResponse) response;
	  
	    if(empservice==null)
	    {
	    	  ServletContext servletContext = request.getServletContext();
	            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	            empservice = (EmployeeServiceIntrfc) webApplicationContext.getBean(EmployeeServiceImpl.class);
	   
	            List<CountryEntity> countryList=new ArrayList<CountryEntity>();
	    		
	    		countryList=(List<CountryEntity>)empservice.fetchAllCountry();
	    		if(countryList!=null && countryList.size()>0)
	    		{
	    			for(CountryEntity cn:countryList)
	    			{
	    				System.out.println(cn.getCname()+" / "+cn.getCid());
	    			}
	    		}
	    }
	    
	    //List<CityEntity> cityList=empservice.fetchAllCity();
	 /*String jwtToken = Jwts.builder().
			 setSubject("LoginAuthentication").
			 claim("roles", "user").
			 claim("name", req.getParameter("username")).
			 claim("scope", "self groups/admins").
			 claim("code", "S1001").
			 setIssuedAt(new Date()).
			 setId(req.getParameter("username")+req.getParameter("password"))
	         .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	 req.setAttribute("AUTHTOKEN", jwtToken);*/

	        chain.doFilter(req, resp);
	    
	
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

	


}
