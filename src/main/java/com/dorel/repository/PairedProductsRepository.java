package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.PairedProducts;

@Repository
public interface PairedProductsRepository extends JpaRepository<PairedProducts, Long> {

	PairedProducts findByProductcodeAndProductserialnoAndAddedbyAndActive(String productcode, String Productserialno,UUID addedby,boolean active);
	
	PairedProducts findByProductcodeAndProductserialnoAndActive(String productcode, String Productserialno,boolean active);
	
	PairedProducts findByProductserialnoAndAddedbyAndActive(String Productserialno,UUID addedby,boolean activeflag);
	
	PairedProducts findByProductserialnoAndActive(String Productserialno,boolean activeflag);
	
	PairedProducts findByProductserialno(String Productserialno);
	
	PairedProducts findByPairedproductid(UUID Pairedproductid);
	
	List<PairedProducts> findByProductcode(String productcode);

	List<PairedProducts> findByAddedby(UUID addedby);
	
	public static final String findbyProductserialnoContaining = "SELECT * FROM pairedproducts p where p.productcode =:productcode and p.active = :active and p.productserialno like :productserialno";
	@Query(value = findbyProductserialnoContaining, nativeQuery = true)
	List<PairedProducts> findByActiveAndProductserialnoContaining(@Param("productcode") String productcode, @Param("active") boolean active, @Param("productserialno") String productserialno);
	
	
	public static final String findbyProductserialnoIn = "SELECT * FROM pairedproducts p where p.productcode =:productcode and p.active = :active and p.productserialno in :productserialnos";  
	@Query(value = findbyProductserialnoIn, nativeQuery = true)
	List<PairedProducts> findByActiveAndProductserialnoIn(@Param("productcode") String productcode, @Param("active") boolean active, @Param("productserialnos") List<String> productserialnos);

}
