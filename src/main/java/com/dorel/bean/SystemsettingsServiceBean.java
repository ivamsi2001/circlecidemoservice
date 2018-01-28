package com.dorel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorel.model.Systemsettings;
import com.dorel.repository.SystemsettingsRepository;
import com.dorel.service.SystemsettingsService;

@Service
public class SystemsettingsServiceBean implements SystemsettingsService{

	@Autowired
	private SystemsettingsRepository settingsRepo;
	
	@Override
	public Systemsettings getSystemSettingsByType(String settingtype) {

		return settingsRepo.findBySettingtype(settingtype);
	}

	@Override
	public void saveSystemsettings(Systemsettings sysobj) {
		settingsRepo.save(sysobj);
	}

}
