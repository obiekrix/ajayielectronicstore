package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.Category;


public interface CategoryDAO {
	
	List<Category> getCategories();

	void saveCategory(Category theCategory);

	void updateCategory(Category theCategory);
	
	Category getCategory(int theId);

	void deleteCategory(int theId);

}
