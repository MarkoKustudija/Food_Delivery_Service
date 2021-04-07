package fds.food_delivery.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "billnumber",nullable = false, unique = true)
	private int billNumber;
	@Column(nullable = false)
	private LocalDateTime date;
	@Column(nullable = false)
	private double price;
	@OneToOne
	private Ordering ordering;
	
	
	public Bill() {
		super();
	}


	public Bill(Long id, int billNumber, LocalDateTime date, double price, Ordering ordering) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.date = date;
		this.price = price;
		this.ordering = ordering;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getBillNumber() {
		return billNumber;
	}


	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Ordering getOrdering() {
		return ordering;
	}


	public void setOrdering(Ordering ordering) {
		this.ordering = ordering;
	}
	
	


	

	

	

	
	
	
	
	
	

}
