package com.app.skp.response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class LoginResponse {

	
	private Integer usreId;
	private String name;
	private String userType;
	private boolean isValidLogin;
	private String pwdChanged;
	private DashboardResponse dashboard;
	public LoginResponse() {
		super();
	}
	public Integer getUsreId() {
		return usreId;
	}
	public void setUsreId(Integer usreId) {
		this.usreId = usreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isValidLogin() {
		return isValidLogin;
	}
	public void setValidLogin(boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}

	public String getPwdChanged() {
		return pwdChanged;
	}
	public void setPwdChanged(String pwdChanged) {
		this.pwdChanged = pwdChanged;
	}
	public DashboardResponse getDashboard() {
		return dashboard;
	}
	public void setDashboard(DashboardResponse dashboard) {
		this.dashboard = dashboard;
	}
	@Override
	public String toString() {
		return "LoginResponse [usreId=" + usreId + ", name=" + name + ", userType=" + userType + ", isValidLogin="
				+ isValidLogin + ", pwdChanged=" + pwdChanged + ", dashboard=" + dashboard + "]";
	}
	
}
