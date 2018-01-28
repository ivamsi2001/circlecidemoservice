package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Tmpuserloginemail;

@Repository
public interface TmpuserloginemailRepository extends JpaRepository<Tmpuserloginemail, Long> {

	List<Tmpuserloginemail> findByDjguserid(UUID djguserid);
	
	List<Tmpuserloginemail> findByNewemail(String newemail);
	
	Tmpuserloginemail findByDjguseridAndNewemailAndActive(UUID djguserid, String newemail, boolean active);
	
	Tmpuserloginemail findByNewemailAndActive(String newemail, boolean active);

}
