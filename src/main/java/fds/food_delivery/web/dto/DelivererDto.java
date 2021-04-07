package fds.food_delivery.web.dto;

import java.util.HashSet;
import java.util.Set;

public class DelivererDto {
	
	
	private Long id;
	
	
	private String personalNumber;
	

	private String idNumber;
	
	
	private String nameSurname;
	
	
	private Set<OrderingDto> orders = new HashSet<>();


	public DelivererDto() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPersonalNumber() {
		return personalNumber;
	}


	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	

	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getNameSurname() {
		return nameSurname;
	}


	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}


	public Set<OrderingDto> getOrders() {
		return orders;
	}


	public void setOrders(Set<OrderingDto> orders) {
		this.orders = orders;
	}
	
	

}
