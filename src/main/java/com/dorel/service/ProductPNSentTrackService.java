package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.ProductPNSentTrack;

public interface ProductPNSentTrackService {

	List<ProductPNSentTrack> getProductPNbyUserWithEvent(UUID djguserid, String productserialno, boolean eventtrigger, boolean eventcomplete);
	
	List<ProductPNSentTrack> getProductPNbySerialno(String productserialno, boolean eventtrigger, boolean eventcomplete);

	void saveProductPNinfoLog(ProductPNSentTrack obj);
}
