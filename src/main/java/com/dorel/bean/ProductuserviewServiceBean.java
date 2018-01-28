package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Productuserview;
import com.dorel.repository.ProductuserviewRepository;
import com.dorel.service.ProductuserviewService;

@Service
public class ProductuserviewServiceBean implements ProductuserviewService{

	protected final static  Logger log = LoggerFactory.getLogger(ProductuserviewServiceBean.class);

	@Autowired
	private ProductuserviewRepository  productuserviewRepository;
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public List<Productuserview> getByMovementSensitivity(String productserialno, String movementswitch, int movlevel) {

		return productuserviewRepository.findByProductserialnoAndMovementswitchAndMovementsensitivityLessThanEqual(productserialno, movementswitch, movlevel );
	}

	@Override
	public List<Productuserview> getBySoundSensitivity(String productserialno, String soundswitch, int soundlevel) {

		return productuserviewRepository.findByProductserialnoAndSoundswitchAndSoundsensitivityLessThanEqual(productserialno, soundswitch, soundlevel);
	}

	@Override
	public Object getMaxSoundAndMovementByCamera(String productserialno) {

		return productuserviewRepository.findBySoundAndSensitivityByCamera(productserialno);
	}

	@Override
	public Productuserview getMaxSoundAndMovementByProductserialno(String productserialno,UUID djguserid) {
		Productuserview puv = new Productuserview();
		String findsoundsensitivitybycamera = "select max(soundsensitivity) as soundsensitivity from Productuserview where productserialno = :productserialno and djguserid != :djguserid";
		try{
			int soundsensitivity =(Integer) entityManager.createQuery(findsoundsensitivitybycamera).setParameter("productserialno", productserialno).setParameter("djguserid", djguserid).getSingleResult();
			puv.setSoundsensitivity(soundsensitivity);
		}catch(Exception e){
			puv.setSoundsensitivity(0);
			log.info(" soundsensitivity is null..");
		}
		try{
			String findmovementsensitivitybycamera = "select max(movementsensitivity) as movementsensitivity from Productuserview where productserialno = :productserialno and djguserid != :djguserid";
			int movementsensitivity =(Integer) entityManager.createQuery(findmovementsensitivitybycamera).setParameter("productserialno", productserialno).setParameter("djguserid", djguserid).getSingleResult();
			puv.setMovementsensitivity(movementsensitivity);

		}catch(Exception e){
			log.info(" movementsensitivity is null..");
			puv.setMovementsensitivity(0);
		}

		try{
			String findsoundswitchbycamera = "select max(soundswitch) as soundswitch from Productuserview where productserialno = :productserialno and djguserid != :djguserid";
			String soundswitch =(String) entityManager.createQuery(findsoundswitchbycamera).setParameter("productserialno", productserialno).setParameter("djguserid", djguserid).getSingleResult();
			puv.setSoundswitch(soundswitch);

		}catch(Exception e){
			log.info(" soundswitch is null..");
		}
		try{
			String findmovementswitchbycamera = "select max(movementswitch) as movementswitch from Productuserview where productserialno = :productserialno and djguserid != :djguserid";
			String movementswitch =(String) entityManager.createQuery(findmovementswitchbycamera).setParameter("productserialno", productserialno).setParameter("djguserid", djguserid).getSingleResult();
			puv.setMovementswitch(movementswitch);

		}catch(Exception e){
			log.info(" movementswitch is null..");
		}
		
		return puv;
	}

	@Override
	public Object findByProductserialno(String productserialno) {

		return productuserviewRepository.findByproductserialno(productserialno);
	}

	@Override
	public Object findByProductserialnoWithUserid(String productserialno, UUID djguserid) {
		// TODO Auto-generated method stub
		return productuserviewRepository.findByproductserialnoWithDjguserid(productserialno, djguserid);
	}

}
