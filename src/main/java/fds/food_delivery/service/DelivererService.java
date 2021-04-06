package fds.food_delivery.service;

import java.util.List;

import fds.food_delivery.model.Deliverer;

public interface DelivererService {
	
	Deliverer findOne(Long id);
	
	List<Deliverer> findAll();

}
