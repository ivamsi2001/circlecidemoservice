package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.ProductUsers;

public interface ProductUsersService {

	List<ProductUsers> getByDjgUseridAndProductcode(UUID djguserid, String productcode, boolean active);
	
	ProductUsers getByDjguseridAndProductcodeAndProductserialno(UUID djguserid, String productcode, String Productserialno, boolean active);
	
	ProductUsers getByDjguseridAndPairedproductidAndProductserialno(UUID djguserid, UUID pairedproductid, String Productserialno, boolean active);

	List<ProductUsers> getByDjguserid(UUID djguserid, boolean active);
	
	List<ProductUsers> getByCameraid( String Productserialno, boolean active);
	
	void saveProductUsers(ProductUsers prodObj);

	ProductUsers getByDjguseridAndProductserialnoAndActive(UUID djguserid, String Productserialno);
	
	ProductUsers isAdmindProductserialno(UUID djguserid, String Productserialno);
	
	List<ProductUsers> getAllProductsByDjguserid(UUID djguserid);
	
	List<ProductUsers> getAllMembersByDjguserid(UUID djguserid, String role);
	
	ProductUsers getByProductuserid(UUID productuserid);

	ProductUsers getByPairedproductidAndDjguserid(UUID pairedproductid, UUID djguserid);
	
	ProductUsers getByDjguseridAndProductserialnoAndStatus(UUID djguserid, String Productserialno, List<String> status);
}
