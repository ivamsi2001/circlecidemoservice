package com.dorel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.TEKEventPNCallLog;

@Repository
public interface TEKEventPNCallLogRepository extends JpaRepository<TEKEventPNCallLog, Long> {

	//List<TEKEventPNCallLog> findByCameraidAndUtctimeOrderByDateaddedAsc(String productserialno, long utctime);
	
	public static final String getByCameraIdByUtctime = "SELECT * FROM tekeventpncalllog  where cameraid =:cameraid and utctime in :utctime";  
	@Query(value = getByCameraIdByUtctime, nativeQuery = true)
	List<TEKEventPNCallLog> findByCameraidByUtctime(@Param("cameraid") String cameraid, @Param("utctime") List<Long> utctime);
	
	public static final String getByCameraIdAndSubtype = "SELECT * FROM tekeventpncalllog  where cameraid =:cameraid and subtype in :subtype order by dateadded desc limit 1";  
	@Query(value = getByCameraIdAndSubtype, nativeQuery = true)
	TEKEventPNCallLog findByCameraidAndSubtype(@Param("cameraid") String cameraid, @Param("subtype") List<String> subtype);
}
