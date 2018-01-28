package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.Productuserview;
@Repository
public interface ProductuserviewRepository extends JpaRepository<Productuserview, Long> {
	
	List<Productuserview> findByProductserialnoAndSoundswitchAndSoundsensitivityLessThanEqual(String productserialno, String soundswitch,int soundsensitivity);

	List<Productuserview> findByProductserialnoAndMovementswitchAndMovementsensitivityLessThanEqual(String productserialno, String movementswitch, int Movementsensitivity);

	public static final String findbycamera = "select max(soundsensitivity) as soundsensitivity, min(movementsensitivity) as movementsensitivity from productuserview where productserialno = :productserialno ";

	
//	@Query("select max(soundsensitivity) as soundsensitivity, min(movementsensitivity) as movementsensitivity from productuserview where productserialnov ")
	@Query(value = findbycamera, nativeQuery = true)
	Object findBySoundAndSensitivityByCamera(@Param("productserialno") String productserialno);
	
	
	public static final String findbyproductserialno="select min(movementsensitivity) as movementsensitivity, min(soundsensitivity) as soundsensitivity, "
			+ "max(soundswitch) as soundswitch, max(movementswitch) as movementswitch from Productuserview where productserialno = :productserialno ";
	
	@Query(value = findbyproductserialno, nativeQuery = true)
	Object findByproductserialno(@Param("productserialno") String productserialno);
	
	public static final String findbyproductserialnoWithuserid="select min(movementsensitivity) as movementsensitivity, min(soundsensitivity) as soundsensitivity, "
			+ "max(soundswitch) as soundswitch, max(movementswitch) as movementswitch from Productuserview where productserialno = :productserialno and djguserid = :djguserid";
	
	@Query(value = findbyproductserialnoWithuserid, nativeQuery = true)
	Object findByproductserialnoWithDjguserid(@Param("productserialno") String productserialno,@Param("djguserid") UUID djguserid);
}
