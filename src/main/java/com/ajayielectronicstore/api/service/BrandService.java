/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.Brand;
import com.ajayielectronicstore.api.model.BrandModel;

/**
 * @author Christian
 *
 */
public interface BrandService {
	
	List<Brand> getBrands();

	void saveBrand(BrandModel model);

	void updateBrand(Brand theBrand);

	Brand getBrand(int theId);

	void deleteBrand(int theId);
}
