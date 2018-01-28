package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.SensitivityValues;
import com.dorel.repository.SensitivityValuesRepository;
import com.dorel.service.SensitivityValuesService;

@Service
public class SensitivityValuesServiceBean implements SensitivityValuesService {

	
	@Autowired
	private  SensitivityValuesRepository sensitivityValues;

	@Override
	public SensitivityValues getBySensitivityid(int sensitivityid) {
		return sensitivityValues.findBySensitivityid(sensitivityid);
	}

	@Override
	public SensitivityValues getBySensitivitycodevalueAndSensitivitytypeAndProductcode(int sensitivitycodevalue,
			String sensitivitytype, String productcode) {
		return sensitivityValues.findBySensitivitycodevalueAndSensitivitytypeAndProductcode(sensitivitycodevalue, sensitivitytype, productcode);
	}
	
	
}
