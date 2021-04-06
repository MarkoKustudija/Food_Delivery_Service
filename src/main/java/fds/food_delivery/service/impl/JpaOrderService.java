package fds.food_delivery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fds.food_delivery.model.Bill;
import fds.food_delivery.model.Deliverer;
import fds.food_delivery.model.Order;
import fds.food_delivery.repository.BillRepository;
import fds.food_delivery.repository.DelivererRepository;
import fds.food_delivery.repository.OrderRepository;
import fds.food_delivery.service.OrderService;
import fds.food_delivery.support.OrderDtoToOrder;
import fds.food_delivery.web.dto.OrderDto;

@Service
public class JpaOrderService implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private DelivererRepository delivererRepository;
	
	@Autowired
	private OrderDtoToOrder toOrder;

	@Override
	public Order findOne(Long id) {
		return orderRepository.findOneById(id);
	}

	@Override
	public Optional<Order> one(Long id) {
		return orderRepository.one(id);
	}

	@Override
	public Order save(OrderDto orderDto) {
		
		Order order = toOrder.convert(orderDto);
		if(order.getId() == null) {
			
			Bill newBill = billRepository.findById(1L).get();
			order.setBill(newBill);
		}
		
		if(orderDto.getId() != null) {
			Optional<Order> oldOrederOptional = one(orderDto.getId());
			if(oldOrederOptional.isPresent()) {
				Order oldOrder = oldOrederOptional.get();
				Deliverer oldDeliverer = oldOrder.getDeliverer();
				oldDeliverer.removeOrder(orderDto.getId());
				delivererRepository.save(oldDeliverer);
			}
		}
		Deliverer deliverer = order.getDeliverer();
		deliverer.addOrder(order);
		Order savedOrder = orderRepository.save(order);
		delivererRepository.save(deliverer);
	
		return savedOrder;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Order> find(List<Long> ids) {
		return orderRepository.findByIdIn(ids);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order delete(Long id) {
		
		Optional <Order> ordersOptional = orderRepository.findById(id);
		if(ordersOptional.isPresent()) {
			Order order = ordersOptional.get();
			
			Deliverer deliverer = order.getDeliverer();
			deliverer.setId(id);
			deliverer.removeOrder(order.getId());
			
//			Bill bill = order.getBill();
//			bill.removeOrder(order.getId());
			
			billRepository.save(order);
			delivererRepository.save(order);
			orderRepository.deleteById(id);
			
			return order;
			
		}
		return null;
	}

	@Override
	public Page<Order> search(Long id, int pageNum) {
		return orderRepository.search(id, PageRequest.of(pageNum, 4));
	}
	
	

}
