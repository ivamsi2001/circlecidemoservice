package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Productuserview;

public interface ProductuserviewService {

	List<Productuserview> getByMovementSensitivity(String productserialno, String movementswitch,int movlevel);
	
	List<Productuserview> getBySoundSensitivity(String productserialno, String onswitch, int soundlevel);
	
	Object getMaxSoundAndMovementByCamera(String productserialno);
	
	Productuserview getMaxSoundAndMovementByProductserialno(String productserialno, UUID djguserid);
	
	Object findByProductserialno(String productserialno);
	
	Object findByProductserialnoWithUserid(String productserialno,UUID djguserid);
}
