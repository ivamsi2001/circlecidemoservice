package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.DJGUsers;

public interface DJGUsersService {

	 DJGUsers getUserbyUserid(UUID userId);
	 
	 DJGUsers getUserbyEmail(String email);

	 List<DJGUsers> getAllActiveUsers(boolean active);
	 
	 void saveUserRegistration(DJGUsers regObj);

	 DJGUsers getUser(UUID userId,String strSecurePassword);
}
