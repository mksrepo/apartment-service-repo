package com.cog.apartment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tbl_owner")
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="owner_id",length=10)
	private Long ownerId;
	
	@Column(name="owner_nm",length=30,nullable=false)
	private String ownerName;
	
	@Column(name="owner_addr",length=50,nullable=false)
	private String ownerAddress;
	
	@Column(name="email_id",length=20)
	private String emailId;
	
	@Column(name="ph_no",length=10)
	private String phoneNo;
	
	@Column(name = "DEL_IND",nullable=false,length=1)
	private String delInd;
	
	@Column(name = "CRTD_BY",length=10)
	private Long crtdBy;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "CRTD_DT")
	private Date crtdDt;

	@Column(name = "UPDT_BY", length=10)
	private Long updtId;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name = "UPDT_DT")
	private Date updtDt;
	
	public String getDelInd() {
		return delInd;
	}
	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public Long getUpdtId() {
		return updtId;
	}
	public void setUpdtId(Long updtId) {
		this.updtId = updtId;
	}
	public Date getUpdtDt() {
		return updtDt;
	}
	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}	
	
	

}
