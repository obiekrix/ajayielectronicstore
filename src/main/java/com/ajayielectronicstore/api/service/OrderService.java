/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import com.ajayielectronicstore.api.entity.Order;

/**
 * @author Christian
 *
 */
public interface OrderService {
	
	List<Order> getOrders();

	void saveOrder(Order theOrder);

	void updateOrder(Order theOrder);

	Order getOrder(int theId);

	void deleteOrder(int theId);
}
