package com.cog.apartment.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.cog.apartment.utility.ApplicationConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name="tbl_unit_typ")
public class UnitType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnitType(){		
	}	

	public UnitType(Long unitTypId, String unitDesc, char delInd, Long crtdBy, Date crtdDt) {
		super();
		this.unitTypId = unitTypId;
		this.unitDesc = unitDesc;
		this.delInd = delInd;
		this.crtdBy = crtdBy;
		this.crtdDt = crtdDt;		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UNIT_TYP_ID",length=10)
	private Long unitTypId;
	
	@Column(name="UNIT_DESC",nullable=false,length=50)
	private String unitDesc;
	

	
	@Column(name="DEL_IND",nullable=false,length=1)
	private char delInd;

	
	@Column(name="CRTD_BY",length=30)
	private Long crtdBy;

	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@JsonIgnore
	@Column(name="CRTD_DT")
	private Date crtdDt;

	
	@Column(name="UPDT_BY",length=30)
	private String updtBy;
	
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	
	@Column(name="UPDT_DT")
	private Date updtDt;	
	
	
	public Long getUnitTypId() {
		return unitTypId;
	}

	public void setUnitTypId(Long unitTypId) {
		this.unitTypId = unitTypId;
	}

	public String getUnitDesc() {
		return unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}

	@JsonIgnore
	public char getDelInd() {
		return delInd;
	}

	public void setDelInd(char delInd) {
		this.delInd = delInd;
	}

	

	public Long getCrtdBy() {
		return crtdBy;
	}

	public void setCrtdBy(Long crtdBy) {
		this.crtdBy = crtdBy;
	}

	public Date getCrtdDt() {
		return crtdDt;
	}

	public void setCrtdDt(Date crtdDt) {
		this.crtdDt = crtdDt;
	}

	@JsonIgnore
	public String getUpdtBy() {
		return updtBy;
	}

	public void setUpdtBy(String updtBy) {
		this.updtBy = updtBy;
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
