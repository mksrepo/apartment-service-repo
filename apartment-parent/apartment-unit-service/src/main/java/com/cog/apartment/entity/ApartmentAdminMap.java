package com.cog.apartment.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TBL_APT_ADMIN_MAP")
public class ApartmentAdminMap {	
	
	

	@EmbeddedId
	private AppAdminCompKey appAdminCompKey;
	
	public AppAdminCompKey getAppAdminCompKey() {
		return appAdminCompKey;
	}

	public void setAppAdminCompKey(AppAdminCompKey appAdminCompKey) {
		this.appAdminCompKey = appAdminCompKey;
	}


	@Column(name="DEL_IND",nullable=false,length=1)
	private String delInd;
	
	
	@Column(name="CRTD_BY",length=10)
	private Long crtdBy;	
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name="CRTD_DT")
	private Date crtdDt;	
	
	@Column(name="UPDT_BY",length=10)
	private Long updtId;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name="UPDT_DT")
	private Date updtDt;	

//	@JsonIgnore
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
	
	
	

}
