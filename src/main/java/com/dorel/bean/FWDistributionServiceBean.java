package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.FWDistribution;
import com.dorel.repository.FWDistributionRepository;
import com.dorel.service.FWDistributionService;

@Service
public class FWDistributionServiceBean implements FWDistributionService {

	
	@Autowired
	private  FWDistributionRepository fwDistributionRepository;
	
	@Override
	public FWDistribution getByFwdistributionid(UUID fwdistributionid) {
		return fwDistributionRepository.findByFwdistributionid(fwdistributionid);
	}

	@Override
	public FWDistribution getByProductserialnoAndStatus(String productserialno,
			String status) {
		return fwDistributionRepository.findByProductserialnoAndStatusIgnoreCase(productserialno, status);
	}
	
	
	@Override
	public void saveFwdistribution(FWDistribution obj) {
		fwDistributionRepository.save(obj);
	}

	@Override
	public FWDistribution getByProductserialnoAndStatusAndFwversion(String productserialno, String status,
			String fwversion) {
		return fwDistributionRepository.findByProductserialnoAndStatusAndFwversion(productserialno, status, fwversion);
	}

	@Override
	public List<FWDistribution> getByProductserialnoAndStatusIn(String productserialno, List<String> statuses, String fwversion) {
		return fwDistributionRepository.findByProductserialnoAndStatusIn(productserialno, statuses,fwversion);
	}

	@Override
	public FWDistribution getByProductserialnoWithStatus(String productserialno, List<String> status) {
		return fwDistributionRepository.findByProductserialnoWithStatusIn(productserialno, status);
	}

	
	
}
