package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Userproductinvitations;
import com.dorel.repository.UserproductInvitationsRepository;
import com.dorel.service.UserproductInvitationsService;

@Service
public class UserproductInvitationsServiceBean implements UserproductInvitationsService{

	@Autowired
	private UserproductInvitationsRepository invitationrepo;
	
	@Override
	public List<Userproductinvitations> getByEmail(String email) {

		return invitationrepo.findByEmail(email);
	}

	@Override
	public Userproductinvitations saveInvitation(Userproductinvitations inv) {
		return invitationrepo.save(inv);
	}

	@Override
	public Userproductinvitations getByInvitationid(UUID userinvitationid) {
		return invitationrepo.findByUserinvitationid(userinvitationid);
	}

	@Override
	public List<Userproductinvitations> getByProductserialnoAndStatus(String productserialno, String invitationstatus) {
		return invitationrepo.findByProductserialnoAndInvitationstatus(productserialno,invitationstatus);
	}

	@Override
	public Userproductinvitations getByEmailAndProductserialno(String email, String productserialno,String invstatus) {
		// TODO Auto-generated method stub
		return invitationrepo.findByEmailAndProductserialnoAndInvitationstatus(email, productserialno,invstatus);
	}

	@Override
	public List<Userproductinvitations> getByEmailAndInvitationstatus(String email, String invitationstatus) {
		// TODO Auto-generated method stub
		return invitationrepo.findByEmailAndInvitationstatus(email, invitationstatus);
	}
}
