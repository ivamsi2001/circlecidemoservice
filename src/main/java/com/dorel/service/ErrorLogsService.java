package com.dorel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dorel.model.ErrorLogs;

public interface ErrorLogsService {

	void saveError(ErrorLogs err);
	
	List<ErrorLogs> getAllErrors();
	
	Page<ErrorLogs> getAllErrorsBypage(Pageable pageable);
	
}
