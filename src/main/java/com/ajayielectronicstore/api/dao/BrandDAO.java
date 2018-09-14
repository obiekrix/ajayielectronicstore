package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.Brand;


public interface BrandDAO {
	
	List<Brand> getBrands();

	void saveBrand(Brand theBrand);

	void updateBrand(Brand theBrand);
	
	Brand getBrand(int theId);

	void deleteBrand(int theId);

}
