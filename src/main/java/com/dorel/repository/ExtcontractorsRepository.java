package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Extcontractors;
@Repository
public interface ExtcontractorsRepository extends JpaRepository<Extcontractors, Long> {
	
	Extcontractors findByextcontractorcodeAndProductcode(String extcontractorcode, String productcode);

}
