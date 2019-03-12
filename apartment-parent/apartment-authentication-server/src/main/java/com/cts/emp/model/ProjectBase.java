package com.cts.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projectbase")
public class ProjectBase {

	@Id
	@GeneratedValue
	@Column(name="projid")
	private Integer projid;
	
	@Column(name="projname")
	private String projname;
	
	@Column(name="projclient")
	private String projclient;
	
	@Column(name="proj_technology_stack")
	private String proj_technology_stack;

	public Integer getProjid() {
		return projid;
	}

	public void setProjid(Integer projid) {
		this.projid = projid;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getProjclient() {
		return projclient;
	}

	public void setProjclient(String projclient) {
		this.projclient = projclient;
	}

	public String getProj_technology_stack() {
		return proj_technology_stack;
	}

	public void setProj_technology_stack(String proj_technology_stack) {
		this.proj_technology_stack = proj_technology_stack;
	}
	
	
	
	
}
