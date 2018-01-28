package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.ProductUsers;
import com.dorel.repository.ProductUsersRepository;
import com.dorel.service.ProductUsersService;

@Service
public class ProductUsersServiceBean implements ProductUsersService{

	protected final static  Logger log = LoggerFactory.getLogger(ProductUsersServiceBean.class);

	@Autowired
	private ProductUsersRepository  productUsersRepository;
	
	@Override
	public List<ProductUsers> getByDjgUseridAndProductcode(UUID djguserid, String productcode, boolean active) {
		
		return productUsersRepository.findByDjguseridAndProductcodeAndActive(djguserid, productcode, active);
	}

	@Override
	public ProductUsers getByDjguseridAndProductcodeAndProductserialno(UUID djguserid, String productcode,
			String Productserialno, boolean active) {
		return productUsersRepository.findByDjguseridAndProductcodeAndProductserialnoAndActive(djguserid, productcode, Productserialno, active);
	}

	@Override
	public List<ProductUsers> getByDjguserid(UUID djguserid, boolean active) {
		
		return productUsersRepository.findByDjguseridAndActive(djguserid, active);
	}

	@Override
	public void saveProductUsers(ProductUsers prodObj) {
		productUsersRepository.save(prodObj);
		
	}

	@Override
	public ProductUsers getByDjguseridAndPairedproductidAndProductserialno(UUID djguserid, UUID pairedproductid,
			String Productserialno, boolean active) {
		return productUsersRepository.findByDjguseridAndPairedproductidAndProductserialnoAndActive(djguserid, pairedproductid, Productserialno, active);
	}

	@Override
	public List<ProductUsers> getByCameraid(String Productserialno, boolean active) {
		
		return productUsersRepository.findByProductserialnoAndActive(Productserialno,active);
	}
	
	@Override
	public ProductUsers getByDjguseridAndProductserialnoAndActive(UUID djguserid,String Productserialno) {
		return productUsersRepository.findByDjguseridAndProductserialnoAndActive(djguserid, Productserialno,true);
	}

	@Override
	public List<ProductUsers> getAllProductsByDjguserid(UUID djguserid) {
		
		return productUsersRepository.findByDjguserid(djguserid);
	}

	@Override
	public List<ProductUsers> getAllMembersByDjguserid(UUID djguserid, String role) {
		// TODO Auto-generated method stub
		return productUsersRepository.findByDjguseridAndActiveAndDjgrolecode(djguserid,true,role);
	}

	@Override
	public ProductUsers getByProductuserid(UUID productuserid) {
		// TODO Auto-generated method stub
		return productUsersRepository.findByProductuserid(productuserid);
	}

	@Override
	public ProductUsers getByPairedproductidAndDjguserid(UUID pairedproductid, UUID djguserid) {
		// TODO Auto-generated method stub
		return productUsersRepository.findByPairedproductidAndDjguseridAndActive(pairedproductid, djguserid,true);
	}

	@Override
	public ProductUsers isAdmindProductserialno(UUID djguserid, String Productserialno) {
		// TODO Auto-generated method stub
		return productUsersRepository.findByDjguseridAndProductserialnoAndActiveAndDjgrolecode(djguserid, Productserialno,true,"ADMIN");

	}

	@Override
	public ProductUsers getByDjguseridAndProductserialnoAndStatus(UUID djguserid, String Productserialno,
			List<String> status) {
		// TODO Auto-generated method stub
		return productUsersRepository.findByDjguseridAndProductserialnoInStatus(djguserid.toString(), Productserialno, status);
	}


}
