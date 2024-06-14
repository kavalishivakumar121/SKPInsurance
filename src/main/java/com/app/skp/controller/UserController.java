package com.app.skp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.skp.request.LoginRequest;
import com.app.skp.request.PwdChangeRequest;
import com.app.skp.request.SignUpRequest;
import com.app.skp.response.LoginResponse;
import com.app.skp.response.SignUpResponse;
import com.app.skp.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/user")
	public ResponseEntity<SignUpResponse> userRegister(@RequestBody SignUpRequest signUpRequest){

		SignUpResponse response = service.saveUser(signUpRequest);
		if(response.getResponse()!=null) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else if(response.getErrorMsg().contains("Duplicate Email")){
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest){
		LoginResponse userLogin = service.userLogin(loginRequest);
		return new ResponseEntity<>(userLogin,HttpStatus.OK);
	}

	@GetMapping("/recover_pwd/{email}")
	public ResponseEntity<String> recoverPassword(@PathVariable String email){
		boolean isValid = service.recoverPwd(email);
		if(isValid) {
			return new ResponseEntity<>("Password Sent to your email",HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>("Invalid Email",HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updatePwd")
	public ResponseEntity<LoginResponse> updatePassword(@RequestBody PwdChangeRequest pwdChangeRequest){
		LoginResponse updatePwd = service.updatePwd(pwdChangeRequest);
		return new ResponseEntity<>(updatePwd,HttpStatus.OK);
	}

}
