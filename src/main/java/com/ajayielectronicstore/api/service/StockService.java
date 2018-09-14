/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.Stock;
import com.ajayielectronicstore.api.model.StockModel;

/**
 * @author Christian
 *
 */
public interface StockService {
	
	List<Stock> getStocks();

	void saveStock(StockModel model);

	void updateStock(Stock theStock);

	Stock getStock(int theId);

	void deleteStock(int theId);
}
