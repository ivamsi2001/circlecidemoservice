package com.dorel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Extcontractoruserdata;

@Repository
public interface ExtcontractoruserdataRepository  extends JpaRepository<Extcontractoruserdata, Long> {
	
	Extcontractoruserdata findByDjguserid(UUID djguserid);
	
}
