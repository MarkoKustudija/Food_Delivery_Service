package fds.food_delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fds.food_delivery.model.Ordering;
import fds.food_delivery.web.dto.OrderingDto;



public interface OrderingService {
	
    Ordering findOne(Long id);
	
	//Optional<Orders> one(Long id);
	
	//Orders save(OrdersDto orderDto);

	List<Ordering> findAll();
	
	Page<Ordering> findAll(Pageable pageable);

	List<Ordering> find(List<Long> ids);

	Ordering save(Ordering order);

	Ordering update(Ordering order);

	Ordering delete(Long id);

	Page<Ordering> search(Long id, int pageNum);

}
