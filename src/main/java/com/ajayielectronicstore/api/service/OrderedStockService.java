/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.OrderedStock;
import com.ajayielectronicstore.api.util.Cart;

/**
 * @author Christian
 *
 */
public interface OrderedStockService {
	
	List<OrderedStock> getOrderedStocks();

	void saveOrderedStock(Cart cart);

	void updateOrderedStock(OrderedStock theOrderedStock);

	OrderedStock getOrderedStock(int theId);

	void deleteOrderedStock(int theId);
}
