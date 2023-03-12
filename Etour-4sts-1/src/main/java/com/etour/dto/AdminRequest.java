package com.etour.dto;

public class AdminRequest 
{
	
	@Override
	public String toString() {
		return "AdminRequest [phoneno=" + phoneno + ", password=" + password + "]";
	}

	public AdminRequest() {
		super();
	}

	public AdminRequest(String phoneno, String password) {
		super();
		this.phoneno = phoneno;
		this.password = password;
	}

	private String phoneno;
	
	private String password;

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
