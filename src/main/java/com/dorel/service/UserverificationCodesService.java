package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.UserverificationCodes;

public interface UserverificationCodesService {

	 List<UserverificationCodes> getUserProdVerification(UUID userId,String prodcode, String vertype);
	 
	 UserverificationCodes getUserProdVerificationActive(UUID userId,String prodcode, String vertype, boolean flag);
	 
	 UserverificationCodes getUserProdVerification(UUID userId,String prodcode);

	 void saveUserVerification(UserverificationCodes verificationObj);

	UserverificationCodes getUserPasswordVerificationInactive(UUID userId, String prodcode, String vertype, String vcode);

}
