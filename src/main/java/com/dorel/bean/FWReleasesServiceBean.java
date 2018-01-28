package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.FWReleases;
import com.dorel.repository.FWReleasesRepository;
import com.dorel.service.FWReleasesService;

@Service
public class FWReleasesServiceBean implements FWReleasesService {

	@Autowired
	private FWReleasesRepository fwreleasesRepository;
	
	@Override
	public FWReleases getByFwreleaseid(int fwreleaseid) {

		return fwreleasesRepository.findByFwreleaseid(fwreleaseid);
	}

	@Override
	public void saveFwreleases(FWReleases obj) {

		fwreleasesRepository.save(obj);
		
	}

}
