package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Adminview;

@Repository
public interface AdminviewRepository extends JpaRepository<Adminview, Long> {

	List<Adminview> findAll(); 
	
	Page<Adminview> findAllByOrderByDatecreatedDesc(Pageable pageable);
	
	Page<Adminview> findByDjguseridOrderByDatecreatedDesc(UUID Djguserid, Pageable pageable);
	
	Page<Adminview> findByDjguseridOrEmailOrCameralist(UUID Djguserid, String email, String cameralist, Pageable pageable);
	
	Page<Adminview> findByDjguseridOrEmailContainingIgnoreCaseOrCameralistContainingIgnoreCaseOrderByDatecreatedDesc(UUID Djguserid, String email, String cameralist, Pageable pageable);
	
}
