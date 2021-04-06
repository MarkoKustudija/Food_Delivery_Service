package fds.food_delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fds.food_delivery.model.Bill;
import fds.food_delivery.repository.BillRepository;
import fds.food_delivery.service.BillService;

@Service
public class JpaBillService implements BillService{
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill findOne(Long id) {
		return billRepository.findOneById(id);
	}

	@Override
	public List<Bill> findAll() {
		return billRepository.findAll();
	}

}
