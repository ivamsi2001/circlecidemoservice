package com.dorel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Systemsettings;


@Repository
public interface SystemsettingsRepository extends JpaRepository<Systemsettings, Long> {

	Systemsettings findBySettingtype(String settingtype);
}
