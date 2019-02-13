package com.apartmentrule.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.apartmentrule.constant.ApartmentRuleConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This model class responsible for creating table in DB with proper definition
 * @author 748152
 *
 */
@Entity @IdClass(RuleID.class)
@Table(name=ApartmentRuleConstants.APARTMENT_RULE_MASTER)
public class RuleDetailsEntity {
	
    @Column(name = ApartmentRuleConstants.RULE_ID_MODEL, columnDefinition =ApartmentRuleConstants.BIGINT50,nullable = ApartmentRuleConstants.FALSE)
	private  long ruleId;
	@Id
	@Column(name=ApartmentRuleConstants.APARTMENT_ID_MODEL,columnDefinition =ApartmentRuleConstants.VARCHAR10,nullable = ApartmentRuleConstants.FALSE)
	private String apartmentId;
	@Id
	@Column(name=ApartmentRuleConstants.UNIT_TYPE_MODEL,columnDefinition =ApartmentRuleConstants.VARCHAR10,nullable = ApartmentRuleConstants.FALSE)
	private String unitType;
	@Column(name=ApartmentRuleConstants.FIXED_CHARGE,columnDefinition =ApartmentRuleConstants.VARCHAR10)
	private String fixedCharge;
	@Column(name=ApartmentRuleConstants.PER_SQUAREFOOT_CHARGE,columnDefinition =ApartmentRuleConstants.VARCHAR10)
	private String perSquarefootCharge;
	@Column(name=ApartmentRuleConstants.RENT_CHARGE,columnDefinition =ApartmentRuleConstants.VARCHAR10)
	private String rentCharge;
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name=ApartmentRuleConstants.EFFECTIVE_DATE,nullable = ApartmentRuleConstants.FALSE)
	private Date effectiveDate;
	@JsonIgnore
	@Column(name = ApartmentRuleConstants.DELETED, columnDefinition = ApartmentRuleConstants.VARCHAR5, nullable = ApartmentRuleConstants.FALSE)
	private String deleted=ApartmentRuleConstants.NO ;
	public RuleDetailsEntity() {
		super();
	}
	private static long createRuleId() {
		LocalDateTime now = LocalDateTime.now();
		String ruleStr=String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())
		+String.valueOf(now.getHour())+String.valueOf(now.getMinute())+String.valueOf(now.getSecond())+String.valueOf(now.getNano()).substring(0,2);
		System.out.println(Long.valueOf(ruleStr));
		return Long.valueOf(ruleStr);
	}
	public RuleDetailsEntity(long ruleId, String apartmentId, String unitType, String fixedCharge,
			String perSquarefootCharge, String rentCharge, Date effectiveDate,String deleted) {
		super();
		this.ruleId = ruleId;
		this.apartmentId = apartmentId;
		this.unitType = unitType;
		this.fixedCharge = fixedCharge;
		this.perSquarefootCharge = perSquarefootCharge;
		this.rentCharge = rentCharge;
		this.effectiveDate = effectiveDate;
		this.deleted = deleted;
	}
	public long getRuleId() {
		return ruleId;
	}
	public void setRuleId(long ruleId) {
		this.ruleId = createRuleId();
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
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
