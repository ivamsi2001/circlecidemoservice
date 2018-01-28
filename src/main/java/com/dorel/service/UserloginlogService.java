package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Userloginlog;

public interface UserloginlogService {

	Userloginlog getUserBydevicetoken(UUID djguserid, String devicetoken);
	
	List<Userloginlog> getByUser(UUID djguserid);
	
	void saveByloginUser(Userloginlog loginObj);
}
