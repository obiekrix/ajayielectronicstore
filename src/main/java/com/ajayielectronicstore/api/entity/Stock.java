/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayielectronicstore.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "_stock")
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_description")
	private String description;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_features")
	private String features;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_cost_price")
	private BigDecimal costPrice;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_selling_price")
	private BigDecimal sellingPrice;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_orders")
	private Integer orders;
	
	@Basic(optional = true)
	@Column(name = "_last_order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastOrder;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_remaining_quantity")
	private Integer remainingQuantity;

	@Basic(optional = false)
	@Column(name = "_creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_enabled")
	private boolean enabled;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="_admin_id")
    private Admin admin;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "_catagory_id")
	private Category category;

	@ManyToOne(optional = false)
	@JoinColumn(name = "_brand_id")
	private Brand brand;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pk.stock")
	private Set<OrderedStock> orderedStocks = new HashSet<OrderedStock>(0);

	public Stock() {

	}

	/**
	 * @param id
	 */
	public Stock(@NotNull Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param description
	 * @param features
	 * @param costPrice
	 * @param sellingPrice
	 * @param orders
	 * @param lastOrder
	 * @param remainingQuantity
	 * @param creationDate
	 * @param enabled
	 * @param admin
	 * @param category
	 * @param brand
	 * @param orderedStocks
	 */
	public Stock(Integer id, @NotNull String description, @NotNull String features, @NotNull BigDecimal costPrice,
			@NotNull BigDecimal sellingPrice, @NotNull Integer orders, Date lastOrder,
			@NotNull Integer remainingQuantity, Date creationDate, @NotNull boolean enabled, Admin admin,
			Category category, Brand brand) {
		this.id = id;
		this.description = description;
		this.features = features;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.orders = orders;
		this.lastOrder = lastOrder;
		this.remainingQuantity = remainingQuantity;
		this.creationDate = creationDate;
		this.enabled = enabled;
		this.admin = admin;
		this.category = category;
		this.brand = brand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getFeatures() {
		return this.features;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Date getLastOrder() {
		return lastOrder;
	}

	public void setLastOrder(Date lastOrder) {
		this.lastOrder = lastOrder;
	}

	public Integer getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Integer remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<OrderedStock> getOrderedStocks() {
		return orderedStocks;
	}

	public void setOrderedStocks(Set<OrderedStock> orderedStocks) {
		this.orderedStocks = orderedStocks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Stock)) {
			return false;
		}
		Stock other = (Stock) obj;
		if (admin == null) {
			if (other.admin != null) {
				return false;
			}
		} else if (!admin.equals(other.admin)) {
			return false;
		}
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (costPrice == null) {
			if (other.costPrice != null) {
				return false;
			}
		} else if (!costPrice.equals(other.costPrice)) {
			return false;
		}
		if (creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!creationDate.equals(other.creationDate)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (enabled != other.enabled) {
			return false;
		}
		if (features == null) {
			if (other.features != null) {
				return false;
			}
		} else if (!features.equals(other.features)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastOrder == null) {
			if (other.lastOrder != null) {
				return false;
			}
		} else if (!lastOrder.equals(other.lastOrder)) {
			return false;
		}
		if (orderedStocks == null) {
			if (other.orderedStocks != null) {
				return false;
			}
		} else if (!orderedStocks.equals(other.orderedStocks)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (remainingQuantity == null) {
			if (other.remainingQuantity != null) {
				return false;
			}
		} else if (!remainingQuantity.equals(other.remainingQuantity)) {
			return false;
		}
		if (sellingPrice == null) {
			if (other.sellingPrice != null) {
				return false;
			}
		} else if (!sellingPrice.equals(other.sellingPrice)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", description=" + description + ", features=" + features + ", costPrice="
				+ costPrice + ", sellingPrice=" + sellingPrice + ", orders=" + orders + ", lastOrder=" + lastOrder
				+ ", remainingQuantity=" + remainingQuantity + ", creationDate=" + creationDate + ", enabled=" + enabled
				+ ", admin=" + admin + ", category=" + category + ", brand=" + brand + ", orderedStocks="
				+ orderedStocks + "]";
	}

}
