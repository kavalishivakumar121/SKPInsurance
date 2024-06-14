package com.app.skp.request;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
	
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public LoginRequest() {
		super();
	}
	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", pwd=" + pwd + "]";
	}

	
}
