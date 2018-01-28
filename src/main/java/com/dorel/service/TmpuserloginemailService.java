package com.dorel.service;

import java.util.List;
import java.util.UUID;

import com.dorel.model.Tmpuserloginemail;


public interface TmpuserloginemailService {

	
	List<Tmpuserloginemail> getbyUserid(UUID userId);
	 
	List<Tmpuserloginemail> getbyNewemail(String email);

	Tmpuserloginemail getbyUserAndNewemail(UUID userId, String email, boolean flag);

	Tmpuserloginemail getbyNewemailAndActive(String email, boolean flag);

	void saveTempEmail(Tmpuserloginemail tempObj);
}
