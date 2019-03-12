package com.cts.emp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="emp_qualification")
public class EmployeeQualification {

	@Id
	@GeneratedValue
	@Column(name="eqid")
	private Integer eqid;
	
	@OneToOne
	@JoinColumn(name="empid")
	private Employee empId;
	
	@Column(name="heighest_qualif")
	private String hqualif;
	
	@Column(name="marks_percentage")
	private Double marks_percentage;
	
	@Column(name="year_of_passing")
	private String year_of_passing;
	
	@JsonManagedReference("skill")
	@OneToMany(cascade=CascadeType.ALL,mappedBy="eqid",orphanRemoval = true)
	//@Column(name="uid")
	private List<EmployeeSkill> skillList;

	public Integer getEqid() {
		return eqid;
	}

	public void setEqid(Integer eqid) {
		this.eqid = eqid;
	}

	public Employee getEmpId() {
		return empId;
	}

	public void setEmpId(Employee empId) {
		this.empId = empId;
	}

	public String getHqualif() {
		return hqualif;
	}

	public void setHqualif(String hqualif) {
		this.hqualif = hqualif;
	}

	public Double getMarks_percentage() {
		return marks_percentage;
	}

	public void setMarks_percentage(Double marks_percentage) {
		this.marks_percentage = marks_percentage;
	}

	public String getYear_of_passing() {
		return year_of_passing;
	}

	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}

	public List<EmployeeSkill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<EmployeeSkill> skillList) {
		this.skillList = skillList;
	}
	
	
	
}
