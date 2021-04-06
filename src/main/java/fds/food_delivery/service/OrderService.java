package fds.food_delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fds.food_delivery.model.Order;
import fds.food_delivery.web.dto.OrderDto;



public interface OrderService {
	
    Order findOne(Long id);
	
	Optional<Order> one(Long id);
	
	Order save(OrderDto orderDto);

	List<Order> findAll();
	
	Page<Order> findAll(Pageable pageable);

	List<Order> find(List<Long> ids);

	Order save(Order order);

	Order update(Order order);

	Order delete(Long id);

	Page<Order> search(Long id, int pageNum);

}
