package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Userproductinvitations;

@Repository
public interface UserproductInvitationsRepository extends JpaRepository<Userproductinvitations, Long>{

	List<Userproductinvitations> findByEmail(String email);
	
	Userproductinvitations findByUserinvitationid(UUID userinvitationid);
	
	List<Userproductinvitations> findByProductserialnoAndInvitationstatus(String productserialno, String invitationstatus);
	
	Userproductinvitations findByEmailAndProductserialnoAndInvitationstatus(String email,String productserialno,String invitationstatus);
	
	List<Userproductinvitations> findByEmailAndInvitationstatus(String email,String invitationstatus);

}
