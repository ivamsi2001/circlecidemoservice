package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Userproductinvitations;

public interface UserproductInvitationsService {

	List<Userproductinvitations> getByEmail(String email);
	
	Userproductinvitations  getByEmailAndProductserialno(String email,String productserialno,String invstatus);
	
	List<Userproductinvitations> getByProductserialnoAndStatus(String productserialno, String invstatus);

	Userproductinvitations getByInvitationid(UUID userinvitationid);
	
	Userproductinvitations saveInvitation(Userproductinvitations inv);
	
	List<Userproductinvitations> getByEmailAndInvitationstatus(String email, String invitationstatus);

}
