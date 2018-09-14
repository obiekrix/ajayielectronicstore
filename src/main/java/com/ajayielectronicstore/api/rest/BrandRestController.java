/**
 * 
 */
package com.ajayielectronicstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajayielectronicstore.api.entity.Brand;
import com.ajayielectronicstore.api.exception.AppException;
import com.ajayielectronicstore.api.exception.ResourceNotFoundException;
import com.ajayielectronicstore.api.model.BrandModel;
import com.ajayielectronicstore.api.service.BrandService;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/brandapi")
public class BrandRestController {

	@Autowired
	private BrandService brandService;

	@GetMapping("/brands")
	public List<Brand> getBrands() {
		return brandService.getBrands();
	}

	@GetMapping("/brand/{id}")
	public Brand getBrand(@PathVariable int id) {
		
		Brand brand = brandService.getBrand(id);
		
		if(brand == null) {
			throw new ResourceNotFoundException("Stock", "id", id);
		}
		
		return brandService.getBrand(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addBrand(@RequestBody BrandModel model) {
		
		if(!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}
		
		brandService.saveBrand(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateBrand(@PathVariable int id, @RequestBody Brand theBrand) {

		Brand updatedBrand = theBrand;
		updatedBrand.setId(id);
		
		brandService.updateBrand(updatedBrand);

		return ResponseEntity.ok().build();
	}
}
