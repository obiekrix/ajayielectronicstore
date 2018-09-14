/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajayielectronicstore.api.dao.AdminDAO;
import com.ajayielectronicstore.api.dao.CategoryDAO;
import com.ajayielectronicstore.api.entity.Admin;
import com.ajayielectronicstore.api.entity.Category;
import com.ajayielectronicstore.api.model.CategoryModel;

/**
 * @author Christian
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public void saveCategory(CategoryModel model) {
		// TODO Auto-generated method stub

		// get the admin
		Admin admin = adminDAO.getAdmin(model.getAdminId());
				
		// build up the category
		Category category = new Category();
		
		category.setCreationDate(model.getCreationDate());
		category.setDescription(model.getDescription());
		category.setEnabled(model.isEnabled());
		category.setName(model.getName());
		category.setAdmin(admin);
		
		// save the category
		categoryDAO.saveCategory(category);
	}

	@Override
	@Transactional
	public void updateCategory(Category theCategory) {
		// TODO Auto-generated method stub

		categoryDAO.updateCategory(theCategory);
	}

	@Override
	@Transactional
	public Category getCategory(int theId) {
		// TODO Auto-generated method stub

		return categoryDAO.getCategory(theId);
	}

	@Override
	public void deleteCategory(int theId) {
		// TODO Auto-generated method stub

	}

}
