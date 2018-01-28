package com.dorel.service;

import com.dorel.model.Systemsettings;

public interface SystemsettingsService {

	Systemsettings getSystemSettingsByType(String settingtype);
	
	void saveSystemsettings(Systemsettings sysobj);
}
