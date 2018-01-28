package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.UserRole;

public interface RoleService {
	
	UserRole getByUseridWithRole(UUID userid, int roleid);

	UserRole getByUserid(UUID userid);
	
	List<UserRole> getByRoleid(int roleid);	
	
	void saveUserRole(UserRole userObj);
	
	void deleteUserRole(UserRole userObj);
}
