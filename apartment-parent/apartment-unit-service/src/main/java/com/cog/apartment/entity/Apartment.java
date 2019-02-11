package com.cog.apartment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_apartment")
public class Apartment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Apartment(){}

	public Apartment(Long aptId, String aptNm, String aptAddr, Integer noOfFloors, Integer noOfUnits,
			String builderName, Date dateOfPossession, String delInd, Long crtdBy,  Date crtdDt) {
		super();
		this.aptId = aptId;
		this.aptNm = aptNm;
		this.aptAddr = aptAddr;
		this.noOfFloors = noOfFloors;
		this.noOfUnits = noOfUnits;
		this.builderName = builderName;
		this.dateOfPossession = dateOfPossession;
		this.delInd = delInd;
		this.crtdBy = crtdBy;	
		this.crtdDt = crtdDt;		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APT_ID")
	private Long aptId;

	@Column(name = "APT_NM",nullable=false,length=30)
	private String aptNm;

	@Column(name = "APT_ADDR",nullable=false,length=50)
	private String aptAddr;

	@Column(name = "NO_OF_FLOORS",nullable=false)
	private Integer noOfFloors;

	@Column(name = "NO_OF_UNITS",nullable=false)
	private Integer noOfUnits;

	@Column(name = "BUILDER_NAME",nullable=false,length=30)
	private String builderName;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "DATE_OF_POSSESTION",nullable=false)
	private Date dateOfPossession;

	@Column(name = "DEL_IND",nullable=false,length=1)
	private String delInd;

	@Column(name = "CRTD_BY",length=10)
	private Long crtdBy;
	
	@OneToMany(			
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER,
			mappedBy="apartment"
			
	)
	private Set<Unit> units=new HashSet<>();
	
	

	public Set<Unit> getUnits() {
		return units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "CRTD_DT")
	private Date crtdDt;

	@Column(name = "UPDT_BY", length=10)
	private Long updtId;

	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "UPDT_DT")
	private Date updtDt;

	public Long getAptId() {
		return aptId;
	}

	public void setAptId(Long aptId) {
		this.aptId = aptId;
	}

	public String getAptNm() {
		return aptNm;
	}

	public void setAptNm(String aptNm) {
		this.aptNm = aptNm;
	}

	public String getAptAddr() {
		return aptAddr;
	}

	public void setAptAddr(String aptAddr) {
		this.aptAddr = aptAddr;
	}

	public Integer getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Integer noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Integer getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(Integer noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public Date getDateOfPossession() {
		return dateOfPossession;
	}

	public void setDateOfPossession(Date dateOfPossession) {
		this.dateOfPossession = dateOfPossession;
	}

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
	public Long getCrtdBy() {
		return crtdBy;
	}

	public void setCrtdBy(Long crtdBy) {
		this.crtdBy = crtdBy;
	}

	@JsonIgnore
	public Long getUpdtId() {
		return updtId;
	}

	public void setUpdtId(Long updtId) {
		this.updtId = updtId;
	}

	@JsonIgnore
	public Date getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
