package fds.food_delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.repository.DelivererRepository;
import fds.food_delivery.service.DelivererService;

@Service
public class JpaDelivererService implements DelivererService {

	
	@Autowired
	private DelivererRepository delivererRepository;
	@Override
	public Deliverer findOne(Long id) {
		return delivererRepository.findOneById(id);
	}

	@Override
	public List<Deliverer> findAll() {
		return delivererRepository.findAll();
	}
	

}
