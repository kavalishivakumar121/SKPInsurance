package com.app.skp.request;

import org.springframework.stereotype.Component;

@Component
public class PwdChangeRequest {

	private Integer userId;
	private String email;
	private String pwd;
	private String confirmPwd;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public PwdChangeRequest() {
		super();
	}
	@Override
	public String toString() {
		return "PwdChangeRequest [userId=" + userId + ", email=" + email + ", pwd=" + pwd + ", confirmPwd=" + confirmPwd
				+ "]";
	}
	
	
}
