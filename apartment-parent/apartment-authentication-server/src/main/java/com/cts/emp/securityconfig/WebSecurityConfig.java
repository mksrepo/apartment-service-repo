package com.cts.emp.securityconfig;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.emp.filter.JwtAuthenticationFilter;
import com.cts.emp.filter.JwtAuthorisationFilter;
import com.cts.emp.service.EmployeeServiceIntrfc;

@Configuration
public class WebSecurityConfig{//ref: https://www.concretepage.com/spring-boot/spring-boot-filter
	
	
	   
	   
	 //Register Authentication Filter   
	   @Bean
	   public FilterRegistrationBean<JwtAuthenticationFilter> authenticationFilter() {
		   FilterRegistrationBean<JwtAuthenticationFilter> filterRegBean = new FilterRegistrationBean<>();
		   filterRegBean.setFilter(new JwtAuthenticationFilter());
		   filterRegBean.addUrlPatterns("/employeeGeneral/checkLogin/*");	
		   filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -2);
		   return filterRegBean;
	   }
	   
	 //Register Authorization Filter
	   @Bean
	   public FilterRegistrationBean<JwtAuthorisationFilter> authorizationFilter() {
		   FilterRegistrationBean<JwtAuthorisationFilter> filterRegBean = new FilterRegistrationBean<>();
		   filterRegBean.setFilter(new JwtAuthorisationFilter());
		   filterRegBean.addUrlPatterns("/employeeService/*");	
		   filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
		   return filterRegBean;
	   }
	   
	  /* @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }*/
}
