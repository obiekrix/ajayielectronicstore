/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.Category;
import com.ajayielectronicstore.api.model.CategoryModel;

/**
 * @author Christian
 *
 */
public interface CategoryService {
	
	List<Category> getCategories();

	void saveCategory(CategoryModel model);

	void updateCategory(Category theCategory);

	Category getCategory(int theId);

	void deleteCategory(int theId);
}
