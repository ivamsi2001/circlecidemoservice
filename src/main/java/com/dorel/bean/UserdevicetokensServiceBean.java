package com.dorel.bean;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Userdevicetokens;
import com.dorel.repository.UserdevicetokensRepository;
import com.dorel.service.UserdevicetokensService;

@Service
public class UserdevicetokensServiceBean implements UserdevicetokensService{

	@Autowired
	private UserdevicetokensRepository usertokens;
	
	@Override
	public List<Userdevicetokens> getDevicetokens(UUID djguserid, boolean isactive) {

		return usertokens.findByDjguseridAndIsactive(djguserid, isactive);
	}

	@Override
	public List<Userdevicetokens> getDevicetokensWithProduct(UUID djguserid, String productcode, boolean isactive) {

		return usertokens.findByDjguseridAndProductcodeAndIsactive(djguserid, productcode, isactive);
	}

	@Override
	public void saveDevicetoken(Userdevicetokens deviceObj) {
		
		usertokens.save(deviceObj);
	}

	@Override
	public List<Userdevicetokens> getByUserDevicetoken(String devicetoken) {

		return usertokens.findByDevicetokenAndIsactive(devicetoken, true);
	}

	@Override
	public List<Userdevicetokens> getEndpointArnWithActive(String endpointarn, boolean isactive) {
		
		return usertokens.findByEndpointarnAndIsactive(endpointarn, isactive);
	}

}
