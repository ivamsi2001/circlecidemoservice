package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dorel.model.Adminview;
import com.dorel.repository.AdminviewRepository;
import com.dorel.service.AdminviewService;

@Service	
public class AdminviewServiceBean implements AdminviewService{

	@Autowired
	private  AdminviewRepository usersRepository;
	
	@Override
	public List<Adminview> getAllActiveUsers() {
		
		return usersRepository.findAll();
	}

	@Override
	public Page<Adminview> getAllActiveUsersBypage(Pageable pageable, String search) {
		if(search != null && search.trim().length() > 0) {
			boolean isUUID=false;
			UUID djguserid=null;
			try {
				djguserid=UUID.fromString(search);
				if(djguserid != null) {
					isUUID=true;
				}
			}catch(Exception e) {}
			
			if(isUUID) {
				return usersRepository.findByDjguseridOrderByDatecreatedDesc(djguserid, pageable);
			}else {
				return usersRepository.findByDjguseridOrEmailContainingIgnoreCaseOrCameralistContainingIgnoreCaseOrderByDatecreatedDesc(UUID.randomUUID(), search, search, pageable);
			}
		}else {
			return usersRepository.findAllByOrderByDatecreatedDesc(pageable);
		}
	}
	

}
