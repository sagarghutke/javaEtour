package com.etour.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

@Entity
public class Admin 
{
	
	public Admin() {
		super();
	}


	public Admin(int aid, String name, String password, String phoneno, int accesslvl) {
		super();
		this.aid = aid;
		this.name = name;
		this.password = password;
		this.phoneno = phoneno;
		this.accesslvl = accesslvl;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="accesslvl")
	private int accesslvl;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public int getAccesslvl() {
		return accesslvl;
	}

	public void setAccesslvl(int accesslvl) {
		this.accesslvl = accesslvl;
	}


	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", password=" + password + ", phoneno=" + phoneno
				+ ", accesslvl=" + accesslvl + "]";
	}
	
	

}
