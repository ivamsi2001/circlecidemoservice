package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.Userloginlog;

@Repository
public interface UserloginlogServiceRepository extends JpaRepository<Userloginlog, Long>{

	Userloginlog findByDjguseridAndDevicetoken(UUID djguserid, String devicetoken);
	
	public static final String getByUser = "select * from Userloginlog where CAST(djguserid AS character varying)=:djguserid order by datecreated desc limit 5";  
	@Query(value = getByUser, nativeQuery = true)
	List<Userloginlog> findByDjguserid(@Param("djguserid") String djguserid);
}
