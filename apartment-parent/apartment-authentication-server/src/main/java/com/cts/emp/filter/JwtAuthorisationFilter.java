package com.cts.emp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cts.emp.service.EmployeeServiceImpl;
import com.cts.emp.service.EmployeeServiceIntrfc;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtAuthorisationFilter implements Filter{

	private EmployeeServiceIntrfc empservice;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
	    final HttpServletResponse resp = (HttpServletResponse) response;
	    final String authHeader = req.getHeader("authorization");
	   // String authHeader2 = req.getHeader("authorization2");
	    
	  //  System.out.println("Authorization 2: "+authHeader2);

	    if ("OPTIONS".equals(req.getMethod())) {
	        resp.setStatus(HttpServletResponse.SC_OK);

	        chain.doFilter(req, resp);
	    } else {

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            throw new ServletException("Missing or invalid Authorization header");
	        }

	        final String token = authHeader.substring(7);

	        try {
	            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
	            
	            ServletContext servletContext = request.getServletContext();
	            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	            empservice = (EmployeeServiceIntrfc) webApplicationContext.getBean(EmployeeServiceImpl.class);
	   
	       	 String roles = (String) claims.get("roles");
			 String username = (String) claims.get("username");
			 String scope = (String) claims.get("scope");
			 String scode = (String) claims.get("code");
			 System.out.println("at JwtAuthorisationFilter : "+roles+" / "+username+" / "+scope+" / "+scode);
			 
	        } catch (final SignatureException e) {
	            throw new ServletException("Invalid token");
	        }

	        chain.doFilter(req, resp);
	    }
	
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
