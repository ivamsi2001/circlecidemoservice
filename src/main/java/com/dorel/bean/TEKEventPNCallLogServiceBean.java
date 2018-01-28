package com.dorel.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.TEKEventPNCallLog;
import com.dorel.repository.TEKEventPNCallLogRepository;
import com.dorel.service.TEKEventPNCallLogService;

@Service
public class TEKEventPNCallLogServiceBean implements TEKEventPNCallLogService{

	@Autowired
	private TEKEventPNCallLogRepository  tekrepository;
	
	@Override
	public void saveEventTriggerLog(TEKEventPNCallLog obj) {
		tekrepository.save(obj); 
	}

	@Override
	public List<TEKEventPNCallLog> getByCameraIdAndUtc(String productserialno, List<Long> utctime) {
		// TODO Auto-generated method stub
		return tekrepository.findByCameraidByUtctime(productserialno, utctime);
	}

	@Override
	public TEKEventPNCallLog findByCameraidAndSubtype(String productserialno, List<String> subtype) {
		// TODO Auto-generated method stub
		return tekrepository.findByCameraidAndSubtype(productserialno, subtype);
	}

}
