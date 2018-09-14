package com.ajayielectronicstore.api.dao;

import java.util.List;

import com.ajayielectronicstore.api.entity.Order;


public interface OrderDAO {
	
	List<Order> getOrders();

	void saveOrder(Order theOrder);

	void updateOrder(Order theOrder);
	
	Order getOrder(int theId);

	void deleteOrder(int theId);

}
