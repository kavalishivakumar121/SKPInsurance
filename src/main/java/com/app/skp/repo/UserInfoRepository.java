package com.app.skp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.skp.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {

	public UserInfoEntity findByEmail(String email);
}
