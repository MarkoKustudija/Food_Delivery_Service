package fds.food_delivery.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="ordernumber", nullable = false, unique = true)
	private Integer orderNumber; 
	
	@Column(name = "orderdate",nullable = false)
	private LocalDateTime orderDate;
	
	@Column(name = "address",nullable = false)
	private String deliveryAddress;
	
	@Column 
	private double price;
	
	@Column
	private String description;
	
	@OneToOne
	private Bill bill;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Deliverer deliverer;
	
	public Order() {
		super();
	}


	public Order(Long id, Integer orderNumber, LocalDateTime orderDate, String deliveryAddress, double price,
			String description, Bill bill, Deliverer deliverer) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.deliveryAddress = deliveryAddress;
		this.price = price;
		this.description = description;
		this.bill = bill;
		this.deliverer = deliverer;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Integer getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Deliverer getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(Deliverer deliverer) {
		this.deliverer = deliverer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
