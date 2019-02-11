package com.cog.apartment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AppAdminCompKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="admin_id",nullable=false)
	private Long adminId;
	
	@Column(name="apt_id",nullable=false)
	private Long aptId;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getAptId() {
		return aptId;
	}

	public void setAptId(Long aptId) {
		this.aptId = aptId;
	}
	

}
