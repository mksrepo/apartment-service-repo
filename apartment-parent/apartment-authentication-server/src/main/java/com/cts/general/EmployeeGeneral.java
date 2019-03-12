package com.cts.general;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cts.emp.model.CityEntity;
import com.cts.emp.model.CountryEntity;
import com.cts.emp.model.StateEntity;

public class EmployeeGeneral {
	
	private Integer eid;
	private String ename;
	private String eaddr;
	private Integer ecountryid;
	private Integer estateid;
	private Integer ecityid;
	private String edob;
	private String econtact;
	private String egender;
	private String eusername;
	private String epassword;
	

	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public Integer getEcountryid() {
		return ecountryid;
	}
	public void setEcountryid(Integer ecountryid) {
		this.ecountryid = ecountryid;
	}
	public Integer getEstateid() {
		return estateid;
	}
	public void setEstateid(Integer estateid) {
		this.estateid = estateid;
	}
	public Integer getEcityid() {
		return ecityid;
	}
	public void setEcityid(Integer ecityid) {
		this.ecityid = ecityid;
	}
	public String getEdob() {
		return edob;
	}
	public void setEdob(String edob) {
		this.edob = edob;
	}
	public String getEcontact() {
		return econtact;
	}
	public void setEcontact(String econtact) {
		this.econtact = econtact;
	}
	public String getEgender() {
		return egender;
	}
	public void setEgender(String egender) {
		this.egender = egender;
	}
	public String getEusername() {
		return eusername;
	}
	public void setEusername(String eusername) {
		this.eusername = eusername;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	
	
	
}
