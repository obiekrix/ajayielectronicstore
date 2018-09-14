package com.ajayielectronicstore.api.model;

import java.math.BigDecimal;
import java.util.Date;

public class StockModel {

	private String description;
	private String features;
	private BigDecimal costPrice;
	private BigDecimal sellingPrice;
	private Integer orders;
	private Date lastOrder;
	private Integer remainingQuantity;
	private Date creationDate;
	private Boolean enabled;
    private Integer adminId;
	private Integer categoryId;
	private Integer brandId;
	
	public StockModel() {
		
	}

	/**
	 * @param description
	 * @param features
	 * @param costPrice
	 * @param sellingPrice
	 * @param orders
	 * @param lastOrder
	 * @param remainingQuantity
	 * @param creationDate
	 * @param enabled
	 * @param adminId
	 * @param categoryId
	 * @param brandId
	 */
	public StockModel(String description, String features, BigDecimal costPrice, BigDecimal sellingPrice,
			Integer orders, Date lastOrder, Integer remainingQuantity, Date creationDate, Boolean enabled, Integer adminId,
			Integer categoryId, Integer brandId) {
		this.description = description;
		this.features = features;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.orders = orders;
		this.lastOrder = lastOrder;
		this.remainingQuantity = remainingQuantity;
		this.creationDate = creationDate;
		this.enabled = enabled;
		this.adminId = adminId;
		this.categoryId = categoryId;
		this.brandId = brandId;
	}

	public String getDescription() {
		return description;
	}

	public String getFeatures() {
		return features;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public Integer getOrders() {
		return orders;
	}

	public Date getLastOrder() {
		return lastOrder;
	}

	public Integer getRemainingQuantity() {
		return remainingQuantity;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public boolean isInValidState() {
		Integer result = 1;
		
		result *= ((adminId == null) ? 0 : adminId.hashCode());

		result *= ((creationDate == null) ? 0 : 1);
		result *= ((enabled == null) ? 0 : 1);
		result *= ((features == null) ? 0 : 1);
		result *= ((costPrice == null) ? 0 : 1);
		result *= ((sellingPrice == null) ? 0 : 1);
		result *= ((orders == null) ? 0 : 1);
		result *= ((lastOrder == null) ? 0 : 1);
		result *= ((categoryId == null) ? 0 : 1);
		result *= ((brandId == null) ? 0 : 1);
		result *= ((description == null) ? 0 : 1);
		result *= ((remainingQuantity == null) ? 0 : 1);
		
		return result > 0;
	}
	
	@Override
	public String toString() {
		return "StockModel [description=" + description + ", features=" + features + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + ", orders=" + orders + ", lastOrder=" + lastOrder
				+ ", remainingQuantity=" + remainingQuantity + ", creationDate=" + creationDate + ", enabled=" + enabled
				+ ", adminId=" + adminId + ", categoryId=" + categoryId + ", brandId=" + brandId + "]";
	}
	
}
