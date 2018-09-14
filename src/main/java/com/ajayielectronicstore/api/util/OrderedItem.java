package com.ajayielectronicstore.api.util;

import java.math.BigDecimal;

public class OrderedItem {

	private int stockId;
	private int quantity;
	private BigDecimal soldPrice;

	public OrderedItem() {
		
	}
	
	/**
	 * @param stockId
	 * @param quantity
	 * @param soldPrice
	 */
	public OrderedItem(int stockId, int quantity, BigDecimal soldPrice) {
		this.stockId = stockId;
		this.quantity = quantity;
		this.soldPrice = soldPrice;
	}

	public int getStockId() {
		return stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getSoldPrice() {
		return soldPrice;
	}

	@Override
	public String toString() {
		return "OrderedItem [stockId=" + stockId + ", quantity=" + quantity + ", soldPrice=" + soldPrice + "]";
	}

}
