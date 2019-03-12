package com.cts.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="state_tab")
public class StateEntity {

	
	@Id
	@GeneratedValue
	@Column(name="stateid")
	private Integer stateid;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private CountryEntity countryId;
	
	@Column(name="statename")
	private String statename;

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public CountryEntity getCountryId() {
		return countryId;
	}

	public void setCountryId(CountryEntity countryId) {
		this.countryId = countryId;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	
}
