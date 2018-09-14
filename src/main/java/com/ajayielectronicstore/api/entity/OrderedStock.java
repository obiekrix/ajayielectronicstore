package com.ajayielectronicstore.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "_ordered_stock")
@AssociationOverrides({ @AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "_stock_id")),
		@AssociationOverride(name = "pk.order", joinColumns = @JoinColumn(name = "_order_id")) })
public class OrderedStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderedStockId pk = new OrderedStockId();

	@NotNull
	@Basic(optional = false)
	@Column(name = "_quantity")
	private Integer quantity;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_sold_price")
	private BigDecimal soldPrice;

	public OrderedStock() {

	}

	public OrderedStockId getPk() {
		return pk;
	}

	public void setPk(OrderedStockId pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(BigDecimal soldPrice) {
		this.soldPrice = soldPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soldPrice == null) ? 0 : soldPrice.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}
}
