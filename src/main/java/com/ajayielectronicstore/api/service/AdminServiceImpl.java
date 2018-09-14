/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajayielectronicstore.api.dao.AdminDAO;
import com.ajayielectronicstore.api.entity.Admin;

/**
 * @author Christian
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminDAO.getAdmins();
	}

	@Override
	@Transactional
	public void saveAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub

		adminDAO.saveAdmin(theAdmin);
	}

	@Override
	@Transactional
	public void updateAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub

		adminDAO.updateAdmin(theAdmin);
	}

	@Override
	@Transactional
	public Admin getAdmin(int theId) {
		// TODO Auto-generated method stub

		return adminDAO.getAdmin(theId);
	}

	@Override
	public void deleteAdmin(int theId) {
		// TODO Auto-generated method stub

	}

}
