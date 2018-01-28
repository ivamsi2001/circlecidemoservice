package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.SensitivityValues;

@Repository
public interface SensitivityValuesRepository extends JpaRepository<SensitivityValues, Long>{
	
	SensitivityValues findBySensitivityid(int sensitivityid);
	
	
	SensitivityValues findBySensitivitycodevalueAndSensitivitytypeAndProductcode(int sensitivitycodevalue, String sensitivitytype, String productcode);
	
	
}
