package com.cts.emp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name="employee_tab")
public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	@Column(name="eid")
	private Integer eid;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="eaddr")
	private String eaddr;
	
	
	@ManyToOne
	@JoinColumn(name="ecountryid")
	private CountryEntity ecountryid;
	
	
	@ManyToOne
	@JoinColumn(name="estateid")
	private StateEntity estateid;
	
	@ManyToOne
	@JoinColumn(name="ecityid")
	private CityEntity ecityid;
	
	
	@Column(name="edob")
	private String edob;
	
	@Column(name="econtact")
	private String econtact;
	
	
	@Column(name="egender")
	private String egender;
	
	@Column(name="eusername")
	private String eusername;
	
	
	@Column(name="epassword")
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


	public CountryEntity getEcountryid() {
		return ecountryid;
	}


	public void setEcountryid(CountryEntity ecountryid) {
		this.ecountryid = ecountryid;
	}


	public StateEntity getEstateid() {
		return estateid;
	}


	public void setEstateid(StateEntity estateid) {
		this.estateid = estateid;
	}


	public CityEntity getEcityid() {
		return ecityid;
	}


	public void setEcityid(CityEntity ecityid) {
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
