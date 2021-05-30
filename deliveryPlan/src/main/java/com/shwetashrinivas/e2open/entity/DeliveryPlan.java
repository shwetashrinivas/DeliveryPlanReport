package com.shwetashrinivas.e2open.entity;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ShwetaShrinivas
 *
 */

@Entity //@Entity represents a table stored in a database. 
@Table(name = "DELIVERY_PLAN")
public class DeliveryPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryNo;
	
	@Column(name = "PART",length = 20, nullable = false, unique=false)
	private String part;
	
	@Column(name= "DEPOT", length = 20, nullable = false, unique=false)
	private String depot;
	
	@Column(name="CUSTOMER", length = 30, nullable = false, unique=false)
	private String customer;
	
	@Column(name = "QUANTITY", nullable = false, unique=false)
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DUE_DATE", nullable = false, unique=false)
	private LocalDate dueDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DELIVERY_DATE", nullable = false, unique=false)
	private LocalDate deliveryDate;
	
	@Column(name = "MARGIN",nullable = false, unique=false)
	private BigDecimal margin;

	public DeliveryPlan() {}
	
	public DeliveryPlan(Integer deliveryNo, String part, String depot, String customer, int quantity, LocalDate dueDate,
			LocalDate deliveryDate, BigDecimal margin) {
		super();
		this.deliveryNo = deliveryNo;
		this.part = part;
		this.depot = depot;
		this.customer = customer;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.deliveryDate = deliveryDate;
		this.margin = margin;
	}

	public Integer getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(Integer deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	@Override
	public String toString() {
		return "DeliveryPlan [deliveryNo=" + deliveryNo + ", part=" + part + ", depot=" + depot + ", customer="
				+ customer + ", quantity=" + quantity + ", dueDate=" + dueDate + ", deliveryDate=" + deliveryDate
				+ ", margin=" + margin + "]";
	}

}
