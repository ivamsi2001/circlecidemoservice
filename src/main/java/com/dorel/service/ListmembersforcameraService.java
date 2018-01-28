package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Listmembersforcamera;

public interface ListmembersforcameraService {

	List<Listmembersforcamera> getAllMembers(UUID adminuser);
	
	List<Listmembersforcamera> getAllMembers(String email);
	
	List<Listmembersforcamera> getAllMembersAndProductserialno(UUID adminuser,String productserialno);

	List<Listmembersforcamera> getAllMembersAndProductserialnoWithrole(UUID adminuser,String productserialno, String djgrolecode);

}
