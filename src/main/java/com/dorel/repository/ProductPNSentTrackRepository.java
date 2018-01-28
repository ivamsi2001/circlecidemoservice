package com.dorel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.ProductPNSentTrack;

@Repository
public interface ProductPNSentTrackRepository extends JpaRepository<ProductPNSentTrack, Long> {
	
	List<ProductPNSentTrack> findByDjguseridAndProductserialnoAndEventtriggerAndEventcomplete(UUID djguserid,String productserialno,boolean eventtrigger,boolean eventcomplete);

	List<ProductPNSentTrack> findByProductserialnoAndEventtriggerAndEventcomplete(String productserialno,boolean eventtrigger,boolean eventcomplete);

}
