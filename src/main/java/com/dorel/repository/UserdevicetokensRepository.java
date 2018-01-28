package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Userdevicetokens;

@Repository
public interface UserdevicetokensRepository extends JpaRepository<Userdevicetokens, Long>{
	
	
	List<Userdevicetokens> findByDjguseridAndIsactive(UUID djguserid, boolean isactive);
	
	List<Userdevicetokens> findByDjguseridAndProductcodeAndIsactive(UUID djguserid, String productcode, boolean isactive);

	List<Userdevicetokens> findByDevicetokenAndIsactive(String devicetoken,boolean isactive);
	
	List<Userdevicetokens> findByEndpointarnAndIsactive(String endpointarn,boolean isactive);

}
