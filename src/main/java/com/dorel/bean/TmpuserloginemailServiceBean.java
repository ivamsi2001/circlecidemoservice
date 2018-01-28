package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Tmpuserloginemail;
import com.dorel.repository.TmpuserloginemailRepository;
import com.dorel.service.TmpuserloginemailService;

@Service
public class TmpuserloginemailServiceBean implements TmpuserloginemailService{

	@Autowired
	private TmpuserloginemailRepository  tempRepository;
	
	@Override
	public List<Tmpuserloginemail> getbyUserid(UUID userId) {
		
		return tempRepository.findByDjguserid(userId);
	}

	@Override
	public List<Tmpuserloginemail> getbyNewemail(String email) {
		
		return tempRepository.findByNewemail(email);
	}

	@Override
	public Tmpuserloginemail getbyUserAndNewemail(UUID userId, String email, boolean flag) {

		return tempRepository.findByDjguseridAndNewemailAndActive(userId, email, flag);
	}

	@Override
	public void saveTempEmail(Tmpuserloginemail tempObj) {
		tempRepository.save(tempObj);
		
	}

	@Override
	public Tmpuserloginemail getbyNewemailAndActive(String email, boolean flag) {

		return tempRepository.findByNewemailAndActive(email, flag);
	}

}
