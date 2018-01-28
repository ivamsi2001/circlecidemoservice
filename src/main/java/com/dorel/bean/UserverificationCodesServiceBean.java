package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.UserverificationCodes;
import com.dorel.repository.UserverificationCodesRepository;
import com.dorel.service.UserverificationCodesService;

@Service
public class UserverificationCodesServiceBean implements UserverificationCodesService{

	@Autowired
	private  UserverificationCodesRepository verificationRepository;
	
	
	@Override
	public List<UserverificationCodes> getUserProdVerification(UUID userId, String prodcode, String vertype) {
		return verificationRepository.findByDjguseridAndProductcodeAndVerificationcodetype(userId, prodcode,vertype);
	}

	@Override
	public void saveUserVerification(UserverificationCodes verificationObj) {
		verificationRepository.save(verificationObj);
	}

	@Override
	public UserverificationCodes getUserProdVerification(UUID userId, String prodcode) {
		return verificationRepository.findByDjguseridAndProductcode(userId, prodcode);
	}

	@Override
	public UserverificationCodes getUserProdVerificationActive(UUID userId, String prodcode, String vertype, boolean active) {
		return verificationRepository.findByDjguseridAndProductcodeAndVerificationcodetypeAndIsactive(userId, prodcode, vertype, active);
	}

	@Override
	public UserverificationCodes getUserPasswordVerificationInactive(UUID userId, String prodcode, String vertype, String vcode) {
		return verificationRepository.findByDjguseridAndProductcodeAndVerificationcodetypeAndVerificationcodeAndIsactive(userId, prodcode, vertype,vcode,false);
	}
}
