package fds.food_delivery.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class OrderDto {

	
	private Long id;
	@Positive
	private Integer orderNumber; 
	private String orderDate;
	@NotBlank
	@Max(value = 50)
	private String deliveryAddress;
	private double price;
	private String description;
	private Long billId;
	private Long delivererId;
	
	
	public OrderDto() {
		super();
	}

	public OrderDto(Long id, @Positive Integer orderNumber, String orderDate, @NotBlank @Max(50) String deliveryAddress,
			double price, String description, Long billId, Long delivererId) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.deliveryAddress = deliveryAddress;
		this.price = price;
		this.description = description;
		this.billId = billId;
		this.delivererId = delivererId;
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

	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
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


	public Long getBillId() {
		return billId;
	}


	public void setBillId(Long billId) {
		this.billId = billId;
	}


	public Long getDelivererId() {
		return delivererId;
	}


	public void setDelivererId(Long delivererId) {
		this.delivererId = delivererId;
	}
	
	
	
	
}
