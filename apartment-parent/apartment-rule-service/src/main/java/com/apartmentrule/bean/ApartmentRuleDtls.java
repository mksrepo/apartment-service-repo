package com.apartmentrule.bean;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * This request bean class responsible for capturing Data and showing back to user
 */
@Component
public class ApartmentRuleDtls {
	
	private  long ruleId;
	@NotBlank private String apartmentId;
	@NotBlank private String unitType;
	@NotBlank @DecimalMin(value = "0") private String fixedCharge;
	@NotBlank @DecimalMin(value = "0") private String perSquarefootCharge;
	@NotBlank @DecimalMin(value = "0") private String rentCharge;
	@NotNull private String effectiveDate;
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public ApartmentRuleDtls() {
		super();
	}
	public ApartmentRuleDtls(long ruleId, String apartmentId, String unitType, String fixedCharge,
			String perSquarefootCharge, String rentCharge, String effectiveDate) {
		super();
		this.ruleId = ruleId;
		this.apartmentId = apartmentId;
		this.unitType = unitType;
		this.fixedCharge = fixedCharge;
		this.perSquarefootCharge = perSquarefootCharge;
		this.rentCharge = rentCharge;
		this.effectiveDate = effectiveDate;
	}
	public long getRuleId() {
		return ruleId;
	}
	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}
	public String getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getFixedCharge() {
		return fixedCharge;
	}
	public void setFixedCharge(String fixedCharge) {
		this.fixedCharge = fixedCharge;
	}
	public String getPerSquarefootCharge() {
		return perSquarefootCharge;
	}
	public void setPerSquarefootCharge(String perSquarefootCharge) {
		this.perSquarefootCharge = perSquarefootCharge;
	}
	public String getRentCharge() {
		return rentCharge;
	}
	public void setRentCharge(String rentCharge) {
		this.rentCharge = rentCharge;
	}
	
}
