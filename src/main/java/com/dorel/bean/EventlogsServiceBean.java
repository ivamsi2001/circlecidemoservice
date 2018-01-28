package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Eventlogs;
import com.dorel.repository.EventlogsRepository;
import com.dorel.service.EventlogsService;

@Service
public class EventlogsServiceBean implements EventlogsService {

	@Autowired
	private EventlogsRepository logrepo;

	@Override
	public Eventlogs getByProductserialnoAndStarttime(String productserialno, long starttime) {
		return logrepo.findByProductserialnoAndStarttime(productserialno, starttime);
	}

	@Override
	public void updateOrCreateActivityLog(Eventlogs activity) {
		logrepo.save(activity);
	}

}
