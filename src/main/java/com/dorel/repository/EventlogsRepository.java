package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Eventlogs;

@Repository
public interface EventlogsRepository extends JpaRepository<Eventlogs, Long> {
	 
	Eventlogs findByProductserialnoAndStarttime(String productserialno, long starttime);
}
