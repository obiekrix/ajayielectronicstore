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

import com.ajayielectronicstore.api.entity.Category;
import com.ajayielectronicstore.api.exception.AppException;
import com.ajayielectronicstore.api.exception.ResourceNotFoundException;
import com.ajayielectronicstore.api.model.CategoryModel;
import com.ajayielectronicstore.api.service.CategoryService;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/categoryapi")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable int id) {

		Category category = categoryService.getCategory(id);
		
		if(category == null) {
			throw new ResourceNotFoundException("Category", "id", id);
		}
		
		return category;
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addCategory(@RequestBody CategoryModel model) {

		if(!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}
		
		categoryService.saveCategory(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable int id, @RequestBody Category theCategory) {

		Category updatedCategory = theCategory;
		updatedCategory.setId(id);
		
		categoryService.updateCategory(updatedCategory);

		return ResponseEntity.ok().build();
	}
}
