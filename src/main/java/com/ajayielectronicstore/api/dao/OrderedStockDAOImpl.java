/**
 * 
 */
package com.ajayielectronicstore.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajayielectronicstore.api.entity.OrderedStock;

/**
 * @author Christian
 *
 */
@Repository
public class OrderedStockDAOImpl implements OrderedStockDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public OrderedStock getOrderedStock(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// retrieve/read from database using the primary key
		OrderedStock theOrderedStock = currentSession.get(OrderedStock.class, id);

		return theOrderedStock;
	}

	@Override
	public List<OrderedStock> getOrderedStocks() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by order
		Query<OrderedStock> theQuery = currentSession.createQuery("from OrderedStock orderedStock by order",
				OrderedStock.class);

		// execute query and get result list
		List<OrderedStock> orderedStocks = theQuery.getResultList();

		// return the results
		return orderedStocks;
	}

	@Override
	public void saveOrderedStock(OrderedStock theOrderedStockt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderedStock(OrderedStock theOrderedStock) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrderedStock(int theId) {
		// TODO Auto-generated method stub

	}

}
