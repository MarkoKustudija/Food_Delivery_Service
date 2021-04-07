package fds.food_delivery.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Deliverer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "personalnumber", nullable = false, unique = true)
	private String personalNumber;
	
	@Column(name = "idnumber", nullable = false, unique = true)
	private String idNumber;
	
	@Column(name= "namesurname",nullable = false)
	private String nameSurname;
	
	@OneToMany(mappedBy = "deliverer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ordering> orders = new HashSet<>();
	

   

	public Deliverer() {
		super();
	}
	

	public Deliverer(Long id, String personalNumber, String idNumber, String nameSurname, Set<Ordering> orders) {
		super();
		this.id = id;
		this.personalNumber = personalNumber;
		this.idNumber = idNumber;
		this.nameSurname = nameSurname;
		this.orders = orders;
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

	public Set<Ordering> getOrders() {
		return orders;
	}

	public void setOrders(Set<Ordering> orders) {
		this.orders = orders;
	}

	public void removeOrder(Long id) {
		for(Ordering o : this.orders) {
			if(o.getId() == id) {
				this.orders.remove(o);
				this.removeOrder(id);
				return;
			}
		}
		
	}
	
	public void addOrder(Ordering order) {
		this.orders.add(order);
		this.setOrders(orders);
	}
	
	
	
	
	
	
	
	
	
	

}
