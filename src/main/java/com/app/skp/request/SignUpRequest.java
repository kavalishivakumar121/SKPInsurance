package com.app.skp.request;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class SignUpRequest {

	private Integer userId;
	private String name;
	private String email;
	private String pwd;
	private LocalDate dob;
	private String gender;
	private Long phno;
	private Long ssn;
	private String userType;//admin,caseworker,normaluser
	private String pwdChange;//is user updated is pwd or not after login
	public Integer getUserId() {
		return userId;
	}
	public String getPwdChange() {
		return pwdChange;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setPwdChange(String pwdChange) {
		this.pwdChange = pwdChange;
	}
	
	public SignUpRequest() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfoEntity [userId=" + userId + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", dob="
				+ dob + ", gender=" + gender + ", phno=" + phno + ", ssn=" + ssn + ", userType=" + userType
				+ ", pwdChange=" + pwdChange + "]";
	}
	

}
