package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.Admin;


public interface AdminDAO {
	
	List<Admin> getAdmins();

	void saveAdmin(Admin theAdmin);

	void updateAdmin(Admin theAdmin);
	
	Admin getAdmin(int theId);

	void deleteAdmin(int theId);

}
