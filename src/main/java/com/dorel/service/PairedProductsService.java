package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.PairedProducts;

public interface PairedProductsService {

    PairedProducts getByProductcodeAndProductserialnoAndUserbyActive(String productcode, String Productserialno, UUID addedby, boolean active);

    PairedProducts getByProductcodeAndProductserialnoAndActive(String productcode, String Productserialno, boolean active);
    
    PairedProducts getByProductserialnoAndUser(String Productserialno, UUID addedby);
	
    PairedProducts getByProductserialno(String Productserialno);
    
    PairedProducts getByPairedproductid(UUID pairedproductid);
    
	List<PairedProducts> getByProductcode(String productcode);

	List<PairedProducts> getByAddedby(UUID addedby);
	
	PairedProducts  getByProductserialnoWithActive(String Productserialno);

	void savePairedProducts(PairedProducts obj);
	
	List<PairedProducts> findByActiveAndProductserialnoContaining(String productcode, boolean active, String Productserialno);
	
	List<PairedProducts> findByActiveAndProductserialnoIn(String productcode, boolean active, List<String> Productserialno);
	
	
}
