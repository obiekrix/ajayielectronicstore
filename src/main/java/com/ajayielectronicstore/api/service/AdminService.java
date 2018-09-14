/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.Admin;

/**
 * @author Christian
 *
 */
public interface AdminService {
	
	public List<Admin> getAdmins();

	public void saveAdmin(Admin theAdmin);

	public void updateAdmin(Admin theAdmin);

	public Admin getAdmin(int theId);

	public void deleteAdmin(int theId);
}
