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
import fds.food_delivery.model.Ordering;
import fds.food_delivery.repository.BillRepository;
import fds.food_delivery.repository.DelivererRepository;
import fds.food_delivery.repository.OrderingRepository;
import fds.food_delivery.service.OrderingService;
import fds.food_delivery.support.OrderingDtoToOrdering;
import fds.food_delivery.web.dto.OrderingDto;

@Service
public class JpaOrderingService implements OrderingService{
	
	@Autowired
	private OrderingRepository orderRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private DelivererRepository delivererRepository;
	
	@Autowired
	private OrderingDtoToOrdering toOrder;

	@Override
	public Ordering findOne(Long id) {
		return orderRepository.findOneById(id);
	}

//	@Override
//	public Optional<Orders> one(Long id) {
//		return orderRepository.one(id);
//	}

//	@Override
//	public Orders save(OrdersDto orderDto) {
//		
//		Orders order = toOrder.convert(orderDto);
//		if(order.getId() == null) {
//			
//			Bill newBill = billRepository.findById(1L).get();
//			order.setBill(newBill);
//		}
//		
//		if(orderDto.getId() != null) {
//			Optional<Orders> oldOrederOptional = one(orderDto.getId());
//			if(oldOrederOptional.isPresent()) {
//				Orders oldOrder = oldOrederOptional.get();
//				Deliverer oldDeliverer = oldOrder.getDeliverer();
//				oldDeliverer.removeOrder(orderDto.getId());
//				delivererRepository.save(oldDeliverer);
//			}
//		}
//		Deliverer deliverer = order.getDeliverer();
//		deliverer.addOrder(order);
//		Orders savedOrder = orderRepository.save(order);
//		delivererRepository.save(deliverer);
//	
//		return savedOrder;
//	}

	@Override
	public List<Ordering> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Page<Ordering> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Ordering> find(List<Long> ids) {
		return orderRepository.findByIdIn(ids);
	}

	@Override
	public Ordering save(Ordering order) {
		return orderRepository.save(order);
	}

	@Override
	public Ordering update(Ordering order) {
		return orderRepository.save(order);
	}

	@Override
	public Ordering delete(Long id) {
		
		Optional <Ordering> ordersOptional = orderRepository.findById(id);
		if(ordersOptional.isPresent()) {
			Ordering order = ordersOptional.get();
			
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
	public Page<Ordering> search(Long id, int pageNum) {
		return orderRepository.search(id, PageRequest.of(pageNum, 4));
	}
	
	

}
