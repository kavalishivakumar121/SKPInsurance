package com.app.skp.service;

import com.app.skp.request.LoginRequest;
import com.app.skp.request.PwdChangeRequest;
import com.app.skp.request.SignUpRequest;
import com.app.skp.response.LoginResponse;
import com.app.skp.response.SignUpResponse;

public interface UserService {
	
	public SignUpResponse saveUser(SignUpRequest request);
	public LoginResponse userLogin(LoginRequest request);
	public LoginResponse updatePwd(PwdChangeRequest request);
	public boolean recoverPwd(String email);
	

}
