/**
 * 
 */
package com.ajayielectronicstore.api.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajayielectronicstore.api.dao.OrderedStockDAO;
import com.ajayielectronicstore.api.entity.Admin;
import com.ajayielectronicstore.api.entity.Order;
import com.ajayielectronicstore.api.entity.OrderedStock;
import com.ajayielectronicstore.api.entity.Stock;
import com.ajayielectronicstore.api.util.Cart;
import com.ajayielectronicstore.api.util.OrderedItem;

/**
 * @author Christian
 *
 */
@Service
public class OrderedStockServiceImpl implements OrderedStockService {

	@Autowired
	private OrderedStockDAO orderedStockDAO;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<OrderedStock> getOrderedStocks() {
		// TODO Auto-generated method stub
		return orderedStockDAO.getOrderedStocks();
	}

	@Override
	@Transactional
	public void saveOrderedStock(Cart cart) {
		// TODO Auto-generated method stub

		// get the time of this order
		Date timeOfOrder = new GregorianCalendar().getTime();

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Order order = new Order();
		
		order.setTimeOfSale(timeOfOrder);
		order.setAdmin(currentSession.get(Admin.class, cart.getProcessingAdminId()));

		for (OrderedItem orderedItem : cart.getListOfOrderedItems()) {
			Stock stock = currentSession.get(Stock.class, orderedItem.getStockId());
			
			stock.setLastOrder(timeOfOrder);
			stock.setRemainingQuantity(stock.getRemainingQuantity() - orderedItem.getQuantity());
			
			currentSession.update(stock);

			OrderedStock orderedStock = new OrderedStock();
			
			orderedStock.getPk().setOrder(order);
			orderedStock.getPk().setStock(stock);
			orderedStock.setQuantity(orderedItem.getQuantity());
			orderedStock.setSoldPrice(orderedItem.getSoldPrice());			

			order.getOrderedStocks().add(orderedStock);

			currentSession.save(order);
		}
	}

	@Override
	@Transactional
	public void updateOrderedStock(OrderedStock theOrderedStock) {
		// TODO Auto-generated method stub

		orderedStockDAO.updateOrderedStock(theOrderedStock);
	}

	@Override
	@Transactional
	public OrderedStock getOrderedStock(int theId) {
		// TODO Auto-generated method stub

		return orderedStockDAO.getOrderedStock(theId);
	}

	@Override
	public void deleteOrderedStock(int theId) {
		// TODO Auto-generated method stub

	}

}
