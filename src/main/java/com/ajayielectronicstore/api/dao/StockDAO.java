package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.Stock;


public interface StockDAO {
	
	List<Stock> getStocks();

	void saveStock(Stock theStock);

	void updateStock(Stock theStock);
	
	Stock getStock(int theId);

	void deleteStock(int theId);

}
