package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.FWDistribution;

@Repository
public interface FWDistributionRepository extends JpaRepository<FWDistribution, Long>{

	
	FWDistribution findByFwdistributionid(UUID fwdistributionid);
	 
	FWDistribution findByProductserialnoAndStatusIgnoreCase(String productserialno, String status);

	FWDistribution findByProductserialnoAndStatusAndFwversion(String productserialno, String status,String version);
	
	public static final String getByProductserialnoWithStatusIn = "SELECT * FROM fwdistribution where productserialno =:productserialno and status in :statuses order by datecreated desc limit 1";  
	@Query(value = getByProductserialnoWithStatusIn, nativeQuery = true)
	FWDistribution findByProductserialnoWithStatusIn(@Param("productserialno") String productserialno, @Param("statuses") List<String> statuses);

	
	public static final String getByProductserialnoAndStatusIn = "SELECT * FROM fwdistribution p where p.productserialno =:productserialno and p.status in :statuses and p.fwversion=:fwversion";  
	@Query(value = getByProductserialnoAndStatusIn, nativeQuery = true)
	List<FWDistribution> findByProductserialnoAndStatusIn(@Param("productserialno") String productserialno, @Param("statuses") List<String> statuses, @Param("fwversion") String fwversion);

	
}
