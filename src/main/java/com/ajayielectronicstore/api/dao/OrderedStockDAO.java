package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.OrderedStock;


public interface OrderedStockDAO {
	
	List<OrderedStock> getOrderedStocks();

	void saveOrderedStock(OrderedStock theOrderedStock);

	void updateOrderedStock(OrderedStock theOrderedStock);
	
	OrderedStock getOrderedStock(int theId);

	void deleteOrderedStock(int theId);

}
