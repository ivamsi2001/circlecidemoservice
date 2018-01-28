package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Userloginlog;
import com.dorel.repository.UserloginlogServiceRepository;
import com.dorel.service.UserloginlogService;

@Service
public class UserloginlogServiceBean implements UserloginlogService{

	@Autowired
	private UserloginlogServiceRepository loginlog;
	
	@Override
	public Userloginlog getUserBydevicetoken(UUID djguserid, String devicetoken) {
		
		return loginlog.findByDjguseridAndDevicetoken(djguserid, devicetoken);
	}

	@Override
	public void saveByloginUser(Userloginlog loginObj) {
		loginlog.save(loginObj);
	}

	@Override
	public List<Userloginlog> getByUser(UUID djguserid) {
		System.out.println("djguserid --"+djguserid);
		return loginlog.findByDjguserid(djguserid.toString());
	}

}
