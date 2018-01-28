package com.dorel.bean;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Extcontractoruserdata;
import com.dorel.repository.ExtcontractoruserdataRepository;
import com.dorel.service.ExtcontractoruserdataService;

@Service
public class ExtcontractoruserdataBean implements  ExtcontractoruserdataService{

	@Autowired
	private ExtcontractoruserdataRepository extcontractoruserdataRepository;

	@Override
	public Extcontractoruserdata findUserData(UUID djguserid) {
		return extcontractoruserdataRepository.findByDjguserid(djguserid);
	}

	@Override
	public void saveExtUserData(Extcontractoruserdata obj) {
		extcontractoruserdataRepository.save(obj);
		
	}

}
