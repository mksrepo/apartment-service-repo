package com.apartmentrule.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This user friendly response been
 */
@Component
@JsonInclude(value=Include.NON_NULL)
public class ApartmentRuleResponseBean {
	private String status_code;
	private String message;
	private List<ApartmentRuleDtls> ruleList;
	public ApartmentRuleResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ApartmentRuleDtls> getRuleList() {
		return ruleList;
	}
	public void setRuleList(List<ApartmentRuleDtls> ruleList) {
		this.ruleList = ruleList;
	}
	
	

}
