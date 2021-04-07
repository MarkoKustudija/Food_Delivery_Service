package fds.food_delivery.web.dto;



public class BillDto {
	

	private Long id;
	private int billNumber;
	private String date;
	private double price;
	private Long orderingId;
	
	
	public BillDto() {
		super();
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Long getOrderingId() {
		return orderingId;
	}


	public void setOrderingId(Long orderingId) {
		this.orderingId = orderingId;
	}


	
	
	
	
	

}
