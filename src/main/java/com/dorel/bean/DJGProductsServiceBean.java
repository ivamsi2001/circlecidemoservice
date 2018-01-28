package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.DJGProducts;
import com.dorel.repository.DJGProductsRepository;
import com.dorel.service.DJGProductsService;

@Service
public class DJGProductsServiceBean implements DJGProductsService{

	@Autowired
	private DJGProductsRepository repo;
	
	@Override
	public DJGProducts getByProductcode(String productcode) {

		return repo.findByproductcode(productcode);
	}

}
