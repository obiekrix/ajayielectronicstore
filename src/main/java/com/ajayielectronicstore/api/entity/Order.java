/**
 * 
 */
package com.ajayielectronicstore.api.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 * @author Christian
 *
 */
@Entity
@Table(name = "_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_time_of_sale")
	private Date timeOfSale;

	@ManyToOne(optional=false)
    @JoinColumn(name="_admin")
    private Admin admin;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pk.order")
	private Set<OrderedStock> orderedStocks = new HashSet<OrderedStock>(0);

	public Order() {
		
	}
	
	/**
	 * @param id
	 */
	public Order(Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param timeOfSale
	 * @param admin
	 * @param orderedStocks
	 */
	public Order(Integer id, @NotNull Date timeOfSale, Admin admin,	Set<OrderedStock> orderedStocks) {
		this.id = id;
		this.timeOfSale = timeOfSale;
		this.admin = admin;
		this.orderedStocks = orderedStocks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimeOfSale() {
		return timeOfSale;
	}

	public void setTimeOfSale(Date timeOfSale) {
		this.timeOfSale = timeOfSale;
	}

	public Set<OrderedStock> getOrderedStocks() {
		return orderedStocks;
	}

	public void setOrderedStocks(Set<OrderedStock> orderedStocks) {
		this.orderedStocks = orderedStocks;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		if (admin == null) {
			if (other.admin != null) {
				return false;
			}
		} else if (!admin.equals(other.admin)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orderedStocks == null) {
			if (other.orderedStocks != null) {
				return false;
			}
		} else if (!orderedStocks.equals(other.orderedStocks)) {
			return false;
		}
		if (timeOfSale == null) {
			if (other.timeOfSale != null) {
				return false;
			}
		} else if (!timeOfSale.equals(other.timeOfSale)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", timeOfSale=" + timeOfSale + ", admin=" + admin + ", orderedStocks="
				+ orderedStocks + "]";
	}

}
