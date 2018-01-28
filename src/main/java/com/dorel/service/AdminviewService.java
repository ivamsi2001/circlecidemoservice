package com.dorel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dorel.model.Adminview;

public interface AdminviewService {

	 List<Adminview> getAllActiveUsers();
	 
	 Page<Adminview> getAllActiveUsersBypage(Pageable pageable, String search);

}
