package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Userdevicetokens;

public interface UserdevicetokensService {

	List<Userdevicetokens> getDevicetokens(UUID djguserid, boolean isactive);

	List<Userdevicetokens> getEndpointArnWithActive(String endpointarn, boolean isactive);
	
	List<Userdevicetokens> getByUserDevicetoken(String devicetoken);

	List<Userdevicetokens> getDevicetokensWithProduct(UUID djguserid,String productcode, boolean isactive);

	void saveDevicetoken(Userdevicetokens deviceObj);
}
