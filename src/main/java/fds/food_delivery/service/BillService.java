package fds.food_delivery.service;

import java.util.List;

import fds.food_delivery.model.Bill;

public interface BillService {
	
	Bill findOne(Long id);
	
	List<Bill> findAll();

}
