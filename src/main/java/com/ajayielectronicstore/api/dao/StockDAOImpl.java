/**
 * 
 */
package com.ajayielectronicstore.api.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajayielectronicstore.api.entity.Stock;

/**
 * @author Christian
 *
 */
@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Stock getStock(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Stock theStock = currentSession.get(Stock.class, id);

		return theStock;
	}

	@Override
	public List<Stock> getStocks() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... 
		Query<Stock> theQuery = currentSession.createQuery("from Stock order by id", Stock.class);

		// execute query and get result list
		List<Stock> stocks = theQuery.getResultList();

		// return the results
		return stocks;
	}

	@Override
	public void saveStock(Stock theStock) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the stock
		currentSession.save(theStock);
	}

	@Override
	public void updateStock(Stock theStock) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the stock
		currentSession.update(theStock);
	}

	@Override
	public void deleteStock(int theId) {
		// TODO Auto-generated method stub

	}

}
