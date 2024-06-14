package com.app.skp.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.skp.entity.UserInfoEntity;
import com.app.skp.generators.RandomPwdGenerate;
import com.app.skp.repo.UserInfoRepository;
import com.app.skp.request.LoginRequest;
import com.app.skp.request.PwdChangeRequest;
import com.app.skp.request.SignUpRequest;
import com.app.skp.response.DashboardResponse;
import com.app.skp.response.LoginResponse;
import com.app.skp.response.SignUpResponse;
import com.app.skp.service.UserService;
import com.app.skp.utils.EmailUtils;
@Service
public class UserServiceImpl implements UserService{
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserInfoRepository repo;
	@Autowired
	private EmailUtils emailUtil;
	public SignUpResponse saveUser(SignUpRequest request) {
		SignUpResponse response=new SignUpResponse();
		UserInfoEntity user=repo.findByEmail(request.getEmail());
		if(user!=null) {
			response.setErrorMsg("Duplicate Email");
		}
		else {

			String tempPwd=RandomPwdGenerate.generatePassword();
			request.setPwd(tempPwd);
			request.setPwdChange("false");// for the first login set false
			UserInfoEntity entity=new UserInfoEntity();
			BeanUtils.copyProperties(request, entity);
			repo.save(entity);

			String subject="SKP-Account Created";
			String body="Your Password To Login : "+tempPwd;
			boolean isSent = emailUtil.sendEmail(request.getEmail(), subject, body);
			if(isSent) {
				response.setResponse("Registeration Success");
			}
			else {
				response.setErrorMsg("Registration Failed");
			}

		}			return response;
	}

	public LoginResponse userLogin(LoginRequest request) {
		LoginResponse response=new LoginResponse();
		UserInfoEntity entity=new UserInfoEntity();
		entity.setEmail(request.getEmail());
		entity.setPwd(request.getPwd());
		Example<UserInfoEntity> of=Example.of(entity);
		List<UserInfoEntity> allRecords = repo.findAll(of);
		if(!allRecords.isEmpty()) {
			UserInfoEntity user = allRecords.get(0);
			response.setUsreId(user.getUserId());
			response.setUserType(user.getUserType());
			response.setName(user.getName());
			if(user.getPwdChange().equals("true")) {
				//second login
				response.setPwdChanged("true");
				response.setValidLogin(true);
				//set dashboard data 
				DashboardResponse dashBoardResponse = dashBoardResponse();
				response.setDashboard(dashBoardResponse);
			}
			else {
				//first login
				response.setPwdChanged("false");
				response.setValidLogin(true);
			}
		}
		else {
			// if user not found
			response.setValidLogin(false);
		}
		return response;
	}
	public LoginResponse updatePwd(PwdChangeRequest request) {
		LoginResponse response=new LoginResponse();
		Integer userId = request.getUserId();
		Optional<UserInfoEntity> findById = repo.findById(userId);
		if(findById.isPresent()) {
			//update pwd
			UserInfoEntity entity = findById.get();
			entity.setPwd(request.getConfirmPwd());
			entity.setPwdChange("true");
			repo.save(entity);
			//construct dashboard response;
			response.setUserType(entity.getUserType());
			response.setUsreId(entity.getUserId());
			response.setName(entity.getName());
			response.setPwdChanged(entity.getPwdChange());
			response.setValidLogin(true);
			DashboardResponse dashBoardResponse = dashBoardResponse();
			response.setDashboard(dashBoardResponse);
		}
		return response;
	}

	@Override
	public boolean recoverPwd(String email) {

		UserInfoEntity user = repo.findByEmail(email);
		if(user==null) {
			return false;
		}
		String subject="SKP-Recover Password";
		String body="Your Password :: "+user.getPwd();
		return emailUtil.sendEmail(email, subject, body);
	}

	public static DashboardResponse dashBoardResponse() {
		DashboardResponse dashboard=new DashboardResponse();
		dashboard.setPlansCount(100L);
		dashboard.setBenefitAmtTotal(34000.00);
		dashboard.setCitizensApCnt(56L);
		dashboard.setCitizenssDnCnt(44L);
		return dashboard;
	}

}
