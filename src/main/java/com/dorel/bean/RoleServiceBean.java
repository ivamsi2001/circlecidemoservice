package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.UserRole;
import com.dorel.repository.UserRoleRepository;
import com.dorel.service.RoleService;

@Service
public class RoleServiceBean implements RoleService{
	
	@Autowired
	private UserRoleRepository rolerepo;
	
	@Override
	public UserRole getByUserid(UUID userid) {
		// TODO Auto-generated method stub
		return rolerepo.findByUserid(userid);
	}

	@Override
	public List<UserRole> getByRoleid(int roleid) {
		// TODO Auto-generated method stub
		return rolerepo.findByRoleid(roleid);
	}

	@Override
	public UserRole getByUseridWithRole(UUID userid, int roleid) {
		// TODO Auto-generated method stub
		return rolerepo.findByUseridAndRoleid(userid, roleid);
	}

	@Override
	public void saveUserRole(UserRole userObj) {
		rolerepo.save(userObj);
	}

	@Override
	public void deleteUserRole(UserRole userObj) {
		rolerepo.delete(userObj);
		
	}

}
