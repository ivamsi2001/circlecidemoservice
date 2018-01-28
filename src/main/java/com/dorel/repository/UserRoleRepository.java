package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	UserRole findByUseridAndRoleid(UUID userid, int roleid);

	UserRole findByUserid(UUID userid);
	
	List<UserRole> findByRoleid(int roleid);
}
