package com.dorel.bean;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.DJGUsers;
import com.dorel.repository.DJGUsersRepository;
import com.dorel.service.DJGUsersService;

@Service
public class DJGUsersServiceBean implements DJGUsersService{

	@Autowired
	private  DJGUsersRepository usersRepository;
	
	@Override
	public DJGUsers getUserbyUserid(UUID userId) {
		
		return usersRepository.findByDjguserid(userId);
	}

	@Override
	public void saveUserRegistration(DJGUsers regObj) {
		usersRepository.save(regObj);
		
	}

	@Override
	public DJGUsers getUser(UUID userId, String strSecurePassword) {
		
		return usersRepository.findByDjguseridAndPassword(userId, strSecurePassword);
	}

	@Override
	public DJGUsers getUserbyEmail(String email) {
		return usersRepository.findByEmailIgnoreCase(email);
	}

	@Override
	public List<DJGUsers> getAllActiveUsers(boolean active) {

		return usersRepository.findByActive(active);
	}


}
