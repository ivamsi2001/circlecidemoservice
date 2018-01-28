package com.dorel.service;

import com.dorel.model.Eventlogs;

public interface EventlogsService {

	Eventlogs getByProductserialnoAndStarttime(String productserialno, long starttime);
	
	void updateOrCreateActivityLog(Eventlogs activity);
}
