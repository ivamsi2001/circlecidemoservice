package com.dorel.service;

import com.dorel.model.FWReleases;

public interface FWReleasesService {

		FWReleases getByFwreleaseid(int Fwreleaseid);
		
		void saveFwreleases(FWReleases obj);
	
}
