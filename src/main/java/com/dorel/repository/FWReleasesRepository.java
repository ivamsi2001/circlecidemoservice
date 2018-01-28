package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.FWReleases;

@Repository
public interface FWReleasesRepository extends JpaRepository<FWReleases, Long>{

	
	FWReleases findByFwreleaseid(int fwreleaseid);
	
	
}
