/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajayielectronicstore.api.dao.AdminDAO;
import com.ajayielectronicstore.api.dao.BrandDAO;
import com.ajayielectronicstore.api.entity.Admin;
import com.ajayielectronicstore.api.entity.Brand;
import com.ajayielectronicstore.api.model.BrandModel;

/**
 * @author Christian
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDAO brandDAO;
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		return brandDAO.getBrands();
	}

	@Override
	@Transactional
	public void saveBrand(BrandModel model) {
		// TODO Auto-generated method stub

		// get the admin
		Admin admin = adminDAO.getAdmin(model.getAdminId());
				
		// build up the brand
		Brand brand = new Brand();
		
		brand.setCreationDate(model.getCreationDate());
		brand.setEnabled(model.isEnabled());
		brand.setName(model.getName());
		brand.setAdmin(admin);
		
		// save the brand
		brandDAO.saveBrand(brand);
	}

	@Override
	@Transactional
	public void updateBrand(Brand theBrand) {
		// TODO Auto-generated method stub

		brandDAO.updateBrand(theBrand);
	}

	@Override
	@Transactional
	public Brand getBrand(int theId) {
		// TODO Auto-generated method stub

		return brandDAO.getBrand(theId);
	}

	@Override
	public void deleteBrand(int theId) {
		// TODO Auto-generated method stub

	}

}
