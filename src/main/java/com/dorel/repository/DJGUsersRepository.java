package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.DJGUsers;

@Repository
public interface DJGUsersRepository extends JpaRepository<DJGUsers, Long> {

	
	DJGUsers findByDjguserid(UUID djguserid);
	
	DJGUsers findByEmailIgnoreCase(String email);

	DJGUsers findByDjguseridAndPassword(UUID userId,String strSecurePassword);
	
	List<DJGUsers> findByActive(boolean active);
}
