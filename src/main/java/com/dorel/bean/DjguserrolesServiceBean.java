package com.dorel.bean;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Djguserroles;
import com.dorel.repository.DjguserrolesRepository;
import com.dorel.service.DjguserrolesService;

@Service
public class DjguserrolesServiceBean implements DjguserrolesService{

	@Autowired
	private DjguserrolesRepository djguserrolesrepo;
	
	@Override
	public Djguserroles getByDjguserid(UUID djguserid) {

		return djguserrolesrepo.findByDjguserid(djguserid);
	}

	@Override
	public void saveUserRole(Djguserroles obj) {

		djguserrolesrepo.save(obj);
		
	}

}
