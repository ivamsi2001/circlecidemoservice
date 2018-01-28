package com.dorel.service;

import com.dorel.model.DJGProducts;

public interface DJGProductsService {
	
	DJGProducts getByProductcode(String productcode);
}
