/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajayielectronicstore.api.dao.OrderDAO;
import com.ajayielectronicstore.api.entity.Order;

/**
 * @author Christian
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getOrders();
	}

	@Override
	@Transactional
	public void saveOrder(Order theOrder) {
		// TODO Auto-generated method stub

		orderDAO.saveOrder(theOrder);
	}

	@Override
	@Transactional
	public void updateOrder(Order theOrder) {
		// TODO Auto-generated method stub

		orderDAO.updateOrder(theOrder);
	}

	@Override
	@Transactional
	public Order getOrder(int theId) {
		// TODO Auto-generated method stub

		return orderDAO.getOrder(theId);
	}

	@Override
	public void deleteOrder(int theId) {
		// TODO Auto-generated method stub

	}

}
