package com.cts.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city_tab")
public class CityEntity {

	@Id
	@GeneratedValue
	@Column(name="cityid")
	private Integer cityid;
	
	@ManyToOne
	@JoinColumn(name="stateid")
	private StateEntity stateId;
	
	@Column(name="cityname")
	private String cityname;

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public StateEntity getStateId() {
		return stateId;
	}

	public void setStateId(StateEntity stateId) {
		this.stateId = stateId;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	
	
}
