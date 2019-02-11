package com.cog.apartment.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="unit")
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UNIT_ID",length=10)
	private Long unitId;

	@Column(name = "UNIT_TYP_ID",nullable=false,length=10)
	private Long unitTyp;
	
	@OneToOne
	@JoinColumn(name = "UNIT_TYP_ID", nullable=false,insertable=false,updatable=false)
	private UnitType unitType;
	
	
	
	
	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	@Column(name="unit_no",length=10,nullable=false)
	private String unitNo;

	@Column(name = "area",nullable=false)
	private Integer area;

	@Column(name = "owner_id", nullable=false,length=10)
	private Long ownerId;

	@Column(name = "DEL_IND", nullable=false, length=1)
	private String delInd;

	@Column(name = "CRTD_BY", length=10)
	private Long crtdBy;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "CRTD_DT")
	private Date crtdDt;

	@Column(name = "UPDT_BY",length=10)
	private Long updtBy;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "UPDT_DT")
	private Date updtDt;
	
	@Column(name="apt_id", nullable=false)
	private Long aptId;
	

	public Long getAptId() {
		return aptId;
	}

	public void setAptId(Long aptId) {
		this.aptId = aptId;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apt_id", nullable=false,insertable=false,updatable=false)
	private Apartment apartment;	
	

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getUnitTyp() {
		return unitTyp;
	}

	public void setUnitTyp(Long unitTyp) {
		this.unitTyp = unitTyp;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}	

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@JsonIgnore
	public String getDelInd() {
		return delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}	

	@JsonIgnore
	public Date getCrtdDt() {
		return crtdDt;
	}

	public void setCrtdDt(Date crtdDt) {
		this.crtdDt = crtdDt;
	}

	@JsonIgnore
	public Date getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}

	public Long getCrtdBy() {
		return crtdBy;
	}

	public void setCrtdBy(Long crtdBy) {
		this.crtdBy = crtdBy;
	}

	public Long getUpdtBy() {
		return updtBy;
	}

	public void setUpdtBy(Long updtBy) {
		this.updtBy = updtBy;
	}

}
