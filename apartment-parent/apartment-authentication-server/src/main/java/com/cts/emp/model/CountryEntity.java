package com.cts.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_tab")
public class CountryEntity {

	@Id
	@GeneratedValue
	@Column(name="cid")
	private Integer cid;
	
	@Column(name="cname")
	private String cname;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
