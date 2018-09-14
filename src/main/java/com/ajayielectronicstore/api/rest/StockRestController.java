/**
 * 
 */
package com.ajayielectronicstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ajayielectronicstore.api.entity.Stock;
import com.ajayielectronicstore.api.exception.AppException;
import com.ajayielectronicstore.api.exception.ResourceNotFoundException;
import com.ajayielectronicstore.api.model.StockModel;
import com.ajayielectronicstore.api.service.StockService;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/stockapi")
public class StockRestController {

	@Autowired
	private StockService stockService;

	@GetMapping("/stocks")
	public List<Stock> getStocks() {
		return stockService.getStocks();
	}

	@GetMapping("/stock/{id}")
	public Stock getStock(@PathVariable int id) {

		Stock stock = stockService.getStock(id);

		if (stock == null) {
			throw new ResourceNotFoundException("Stock", "id", id);
		}

		return stock;
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addStock(@RequestBody StockModel model) {

		if (!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}

		stockService.saveStock(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateStock(@PathVariable int id, @RequestBody Stock theStock) {

		Stock updatedStock = theStock;
		updatedStock.setId(id);

		stockService.updateStock(updatedStock);

		return ResponseEntity.ok().build();
	}
}
