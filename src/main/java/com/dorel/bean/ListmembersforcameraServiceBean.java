package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Listmembersforcamera;
import com.dorel.repository.ListmembersforcameraRepository;
import com.dorel.service.ListmembersforcameraService;
@Service
public class ListmembersforcameraServiceBean implements ListmembersforcameraService{

	@Autowired
	private ListmembersforcameraRepository repo;
	
	@Override
	public List<Listmembersforcamera> getAllMembers(UUID adminuser) {
		return repo.findByAdminuser(adminuser);
	}

	@Override
	public List<Listmembersforcamera> getAllMembers(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<Listmembersforcamera> getAllMembersAndProductserialno(UUID adminuser, String productserialno) {
		return repo.findByAdminuserAndProductserialno(adminuser, productserialno);
	}

	@Override
	public List<Listmembersforcamera> getAllMembersAndProductserialnoWithrole(UUID adminuser, String productserialno,
			String djgrolecode) {
		return repo.findByAdminuserAndProductserialnoAndDjgrolecode(adminuser, productserialno, djgrolecode);
	}

	
}
