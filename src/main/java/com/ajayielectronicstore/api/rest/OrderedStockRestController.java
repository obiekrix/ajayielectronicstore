/**
 * 
 */
package com.ajayielectronicstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajayielectronicstore.api.entity.OrderedStock;
import com.ajayielectronicstore.api.service.OrderedStockService;
import com.ajayielectronicstore.api.util.Cart;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/orderedstockapi")
public class OrderedStockRestController {

	@Autowired
	private OrderedStockService orderedStockService;

	@GetMapping("/orderedstocks")
	public List<OrderedStock> getOrderedStocks() {
		return orderedStockService.getOrderedStocks();
	}

	@GetMapping("/orderedstock/{id}")
	public OrderedStock getOrderedStock(@PathVariable int id) {
		return orderedStockService.getOrderedStock(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addOrderedStock(@RequestBody Cart cart) {
		orderedStockService.saveOrderedStock(cart);

		return ResponseEntity.ok().build();
	}

}
