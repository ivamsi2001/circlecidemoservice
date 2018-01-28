package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.DJGProducts;

@Repository
public interface DJGProductsRepository extends JpaRepository<DJGProducts, Long> {

	DJGProducts findByproductcode(String productcode);
}
