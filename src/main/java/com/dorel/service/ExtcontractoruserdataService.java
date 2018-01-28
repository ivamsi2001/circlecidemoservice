package com.dorel.service;

import java.util.UUID;

import com.dorel.model.Extcontractoruserdata;

public interface ExtcontractoruserdataService {

	void saveExtUserData(Extcontractoruserdata obj);
	
	Extcontractoruserdata findUserData(UUID djguserid);

}
