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
import com.ajayielectronicstore.api.dao.CategoryDAO;
import com.ajayielectronicstore.api.dao.StockDAO;
import com.ajayielectronicstore.api.entity.Admin;
import com.ajayielectronicstore.api.entity.Brand;
import com.ajayielectronicstore.api.entity.Category;
import com.ajayielectronicstore.api.entity.Stock;
import com.ajayielectronicstore.api.model.StockModel;

/**
 * @author Christian
 *
 */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private BrandDAO brandDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Stock> getStocks() {
		// TODO Auto-generated method stub
		return stockDAO.getStocks();
	}

	@Override
	@Transactional
	public void saveStock(StockModel model) {
		// TODO Auto-generated method stub

		// get the admin
		Admin admin = adminDAO.getAdmin(model.getAdminId());

		// get the brand
		Brand brand = brandDAO.getBrand(model.getBrandId());

		// get the category
		Category category = categoryDAO.getCategory(model.getCategoryId());

		// build up the stock
		Stock stock = new Stock();

		stock.setAdmin(admin);
		stock.setBrand(brand);
		stock.setCategory(category);
		stock.setCostPrice(model.getCostPrice());
		stock.setCreationDate(model.getCreationDate());
		stock.setDescription(model.getDescription());
		stock.setEnabled(model.isEnabled());
		stock.setFeatures(model.getFeatures());
		stock.setLastOrder(model.getLastOrder());
		stock.setOrders(model.getOrders());
		stock.setRemainingQuantity(model.getRemainingQuantity());
		stock.setSellingPrice(model.getSellingPrice());

		// save the stock
		stockDAO.saveStock(stock);
	}

	@Override
	@Transactional
	public void updateStock(Stock theStock) {
		// TODO Auto-generated method stub

		stockDAO.updateStock(theStock);
	}

	@Override
	@Transactional
	public Stock getStock(int theId) {
		// TODO Auto-generated method stub

		return stockDAO.getStock(theId);
	}

	@Override
	public void deleteStock(int theId) {
		// TODO Auto-generated method stub

	}

}
