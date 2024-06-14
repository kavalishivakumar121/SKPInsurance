package com.app.skp.response;

public class SignUpResponse {
	
	private String response;
	private String errorMsg;
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public SignUpResponse() {
		super();
	}
	@Override
	public String toString() {
		return "SignUpResponse [response=" + response + ", errorMsg=" + errorMsg + "]";
	}
	

}
