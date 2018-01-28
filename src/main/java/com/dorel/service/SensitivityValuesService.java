package com.dorel.service;

import com.dorel.model.SensitivityValues;

public interface SensitivityValuesService {

	SensitivityValues getBySensitivityid(int sensitivityid);
	 
	
	SensitivityValues getBySensitivitycodevalueAndSensitivitytypeAndProductcode(int sensitivitycodevalue, String sensitivitytype, String productcode);
	
	
}
