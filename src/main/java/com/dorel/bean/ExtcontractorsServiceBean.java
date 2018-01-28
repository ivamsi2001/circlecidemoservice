package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Extcontractors;
import com.dorel.repository.ExtcontractorsRepository;
import com.dorel.service.ExtcontractorsService;
@Service
public class ExtcontractorsServiceBean implements ExtcontractorsService{

	@Autowired
	private ExtcontractorsRepository contractorRepo;
	
	@Override
	public Extcontractors getExtcontractorcode(String contractorCode, String productCode) {
		
		return contractorRepo.findByextcontractorcodeAndProductcode(contractorCode, productCode);
	}

}
