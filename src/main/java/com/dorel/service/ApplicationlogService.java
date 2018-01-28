package com.dorel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dorel.model.Applicationlog;

public interface ApplicationlogService {

	void saveAppinfo(Applicationlog applog);
	
	List<Applicationlog> getAllLogs();
	
	Page<Applicationlog> getAllLogsBypage(Pageable pageable);
	
	Page<Applicationlog> findAllByApplicationlog(Pageable pageable, String platform, String eventtype, String logtype, String search, String fromdate, String todate);
	
	List<Applicationlog> getByLivestreamlog(String djguserid,String productserialno) ;

}
