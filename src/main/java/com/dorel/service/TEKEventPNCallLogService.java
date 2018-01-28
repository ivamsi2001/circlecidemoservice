package com.dorel.service;

import java.util.List;

import com.dorel.model.TEKEventPNCallLog;

public interface TEKEventPNCallLogService {

	List<TEKEventPNCallLog> getByCameraIdAndUtc(String productserialno, List<Long> utctime);
	
	TEKEventPNCallLog findByCameraidAndSubtype(String productserialno, List<String> subtype);
	
	void saveEventTriggerLog(TEKEventPNCallLog obj);
}
