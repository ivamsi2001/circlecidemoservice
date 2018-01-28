package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.FWDistribution;

public interface FWDistributionService {

	FWDistribution getByFwdistributionid(UUID fwdistributionid);
	 
	FWDistribution getByProductserialnoAndStatus(String productserialno, String status);
	
	FWDistribution getByProductserialnoWithStatus(String productserialno, List<String> status);
	
	FWDistribution getByProductserialnoAndStatusAndFwversion(String productserialno, String status,String fwversion);

	void saveFwdistribution(FWDistribution obj);
	
	List<FWDistribution> getByProductserialnoAndStatusIn(String productserialno, List<String> statuses, String fwversion);
	
	
}
