package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.UserverificationCodes;

@Repository
public interface UserverificationCodesRepository extends JpaRepository<UserverificationCodes, Long> {
	
	List<UserverificationCodes> findByDjguseridAndProductcodeAndVerificationcodetype(UUID djguserid, String productcode, String verificationcodetype);
	
	UserverificationCodes findByDjguseridAndProductcode(UUID djguserid, String productcode);

	UserverificationCodes findByDjguseridAndProductcodeAndVerificationcodetypeAndIsactive(UUID djguserid, String productcode, String verificationcodetype, boolean active);

	UserverificationCodes findByDjguseridAndProductcodeAndVerificationcodetypeAndVerificationcodeAndIsactive(UUID djguserid, String productcode, String verificationcodetype, String verificationcode,boolean active);

}
