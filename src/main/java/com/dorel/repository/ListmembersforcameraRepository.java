package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Listmembersforcamera;

@Repository
public interface ListmembersforcameraRepository  extends JpaRepository<Listmembersforcamera, Long> {

	List<Listmembersforcamera> findByAdminuser(UUID adminuser);
	
	List<Listmembersforcamera> findByEmail(String email);

	List<Listmembersforcamera> findByAdminuserAndProductserialno(UUID adminuser, String productserialno);
	
	List<Listmembersforcamera> findByAdminuserAndProductserialnoAndDjgrolecode(UUID adminuser, String productserialno,String djgrolecode);

}
