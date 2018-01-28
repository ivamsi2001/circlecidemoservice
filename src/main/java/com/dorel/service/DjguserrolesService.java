package com.dorel.service;

import java.util.UUID;

import com.dorel.model.Djguserroles;

public interface DjguserrolesService {

	Djguserroles getByDjguserid(UUID djguserid);
	
	void saveUserRole(Djguserroles obj);
}
