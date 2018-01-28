package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.PairedProducts;
import com.dorel.repository.PairedProductsRepository;
import com.dorel.service.PairedProductsService;

@Service	
public class PairedProductsServiceBean implements PairedProductsService{

	@Autowired
	private PairedProductsRepository pairedProductsRepository;
	
	@Override
	public PairedProducts getByProductcodeAndProductserialnoAndUserbyActive(String productcode, String Productserialno,UUID addedby,boolean active) {
		return pairedProductsRepository.findByProductcodeAndProductserialnoAndAddedbyAndActive(productcode, Productserialno,addedby,active);
	}

	@Override
	public List<PairedProducts> getByProductcode(String productcode) {
		return pairedProductsRepository.findByProductcode(productcode);
	}

	@Override
	public List<PairedProducts> getByAddedby(UUID addedby) {
		return pairedProductsRepository.findByAddedby(addedby);
	}

	@Override
	public void savePairedProducts(PairedProducts obj) {
		pairedProductsRepository.save(obj);
		
	}

	@Override
	public PairedProducts getByProductserialno(String Productserialno) {
		return pairedProductsRepository.findByProductserialno(Productserialno);
	}

	@Override
	public PairedProducts getByPairedproductid(UUID pairedproductid) {
		return pairedProductsRepository.findByPairedproductid(pairedproductid);
	}

	@Override
	public PairedProducts getByProductserialnoAndUser(String Productserialno, UUID addedby) {

		return pairedProductsRepository.findByProductserialnoAndAddedbyAndActive(Productserialno, addedby,true); 
	}
	
	@Override
	public PairedProducts getByProductserialnoWithActive(String Productserialno) {

		return pairedProductsRepository.findByProductserialnoAndActive(Productserialno,true); 
	}

	@Override
	public PairedProducts getByProductcodeAndProductserialnoAndActive(String productcode, String Productserialno, boolean active) {
		return pairedProductsRepository.findByProductcodeAndProductserialnoAndActive(productcode, Productserialno, active);
	}

	@Override
	public List<PairedProducts> findByActiveAndProductserialnoContaining(String productcode, boolean active, String productserialno) {
		return pairedProductsRepository.findByActiveAndProductserialnoContaining(productcode, active, productserialno);
	}

	@Override
	public List<PairedProducts> findByActiveAndProductserialnoIn(String productcode, boolean active, List<String> productserialnos) {
		return pairedProductsRepository.findByActiveAndProductserialnoIn(productcode, active, productserialnos);
	}
	
	

}
