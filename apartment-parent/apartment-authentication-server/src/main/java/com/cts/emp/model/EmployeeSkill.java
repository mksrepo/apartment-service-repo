package com.cts.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="emp_skill")
public class EmployeeSkill {

	
	@Id
	@GeneratedValue
	@Column(name="skillid")
	private Integer skillid;
	
	@JsonBackReference("skill")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eqid")
    private EmployeeQualification eqid;
	
	@Column(name="skillname")
	private String skillname;
	
	@Column(name="working_year")
	private Double working_year;
	
	@Column(name="technology_version")
	private String technology_version;

	public Integer getSkillid() {
		return skillid;
	}

	public void setSkillid(Integer skillid) {
		this.skillid = skillid;
	}

	public EmployeeQualification getEqid() {
		return eqid;
	}

	public void setEqid(EmployeeQualification eqid) {
		this.eqid = eqid;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public Double getWorking_year() {
		return working_year;
	}

	public void setWorking_year(Double working_year) {
		this.working_year = working_year;
	}

	public String getTechnology_version() {
		return technology_version;
	}

	public void setTechnology_version(String technology_version) {
		this.technology_version = technology_version;
	}
	
	
}
