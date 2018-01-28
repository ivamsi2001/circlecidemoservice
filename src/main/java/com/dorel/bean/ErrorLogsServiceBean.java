package com.dorel.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dorel.model.ErrorLogs;
import com.dorel.repository.ErrorLogsRepository;
import com.dorel.service.ErrorLogsService;
@Service
public class ErrorLogsServiceBean implements ErrorLogsService{

	protected final Logger log = LoggerFactory.getLogger(ErrorLogsServiceBean.class);

	@Autowired
	private ErrorLogsRepository errorLogsRepository;
	
	@Override
	public void saveError(ErrorLogs err) {
		errorLogsRepository.save(err);
		
	}

	@Override
	public List<ErrorLogs> getAllErrors() {
		int noOfDays = 14; //i.e one weeks
		Calendar dt = Calendar.getInstance();
		dt.setTime(new Date());            
		dt.add(Calendar.DAY_OF_YEAR, -noOfDays);
		Date date = dt.getTime();
		log.info(" Date from "+date);
		//return errorLogsRepository.findAllByOrderByDateaddedBetween(new Date(), date);
		return errorLogsRepository.findAllByDateaddedGreaterThanOrderByDateaddedDesc(date);
	}

	@Override
	public Page<ErrorLogs> getAllErrorsBypage(Pageable pageable) {
		// TODO Auto-generated method stub
		return errorLogsRepository.findAllByOrderByDateaddedDesc(pageable);
	}
}
