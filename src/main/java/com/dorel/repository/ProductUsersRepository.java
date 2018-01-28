package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.ProductUsers;

@Repository
public interface ProductUsersRepository  extends JpaRepository<ProductUsers, Long> {
	
	List<ProductUsers> findByDjguseridAndProductcodeAndActive(UUID djguserid, String productcode, boolean active);
	
	ProductUsers findByDjguseridAndProductcodeAndProductserialnoAndActive(UUID djguserid, String productcode, String Productserialno, boolean active);
	
	ProductUsers findByDjguseridAndPairedproductidAndProductserialnoAndActive(UUID djguserid, UUID pairedproductid, String Productserialno, boolean active);

	List<ProductUsers> findByDjguseridAndActive(UUID djguserid, boolean active);
	
	List<ProductUsers> findByProductserialnoAndActive(String Productserialno,boolean active);
	
	ProductUsers findByDjguseridAndProductserialnoAndActive(UUID djguserid,String Productserialno,boolean active);
	
	ProductUsers findByDjguseridAndProductserialnoAndStatus(UUID djguserid,String Productserialno,String status);
	
	List<ProductUsers> findByDjguserid(UUID djguserid);
	
	List<ProductUsers> findByDjguseridAndActiveAndDjgrolecode(UUID djguserid, boolean active,String role);

	ProductUsers findByProductuserid(UUID productuserid);
	
	ProductUsers findByPairedproductidAndDjguseridAndActive(UUID pairedproductid,UUID djguserid,boolean active);

	ProductUsers findByDjguseridAndProductserialnoAndActiveAndDjgrolecode(UUID djguserid, String productserialno,
			boolean active, String admin);
	
	public static final String getByProductserialnoAndStatusIn = "select * FROM productusers where CAST(djguserid AS character varying)=:djguserid and productserialno =:productserialno and status in :statuses";  
	@Query(value = getByProductserialnoAndStatusIn, nativeQuery = true)
	ProductUsers findByDjguseridAndProductserialnoInStatus(@Param("djguserid") String djguserid,@Param("productserialno") String productserialno, @Param("statuses") List<String> statuses);
	
	
}
