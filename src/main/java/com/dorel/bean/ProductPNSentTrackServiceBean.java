package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.ProductPNSentTrack;
import com.dorel.repository.ProductPNSentTrackRepository;
import com.dorel.service.ProductPNSentTrackService;

@Service
public class ProductPNSentTrackServiceBean implements ProductPNSentTrackService{

	@Autowired
	private ProductPNSentTrackRepository  productPNrepository;

	@Override
	public void saveProductPNinfoLog(ProductPNSentTrack obj) {
		productPNrepository.save(obj);
	}

	@Override
	public List<ProductPNSentTrack> getProductPNbyUserWithEvent(UUID djguserid, String productserialno, boolean eventtrigger, boolean eventcomplete) {
		return productPNrepository.findByDjguseridAndProductserialnoAndEventtriggerAndEventcomplete(djguserid,productserialno, eventtrigger,eventcomplete);
	}

	@Override
	public List<ProductPNSentTrack> getProductPNbySerialno(String productserialno, boolean eventtrigger,
			boolean eventcomplete) {
		
		return productPNrepository.findByProductserialnoAndEventtriggerAndEventcomplete(productserialno, eventtrigger, eventcomplete);
	}


}
