package fds.food_delivery.support;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.model.Ordering;
import fds.food_delivery.service.DelivererService;
import fds.food_delivery.service.OrderingService;
import fds.food_delivery.web.dto.DelivererDto;
import fds.food_delivery.web.dto.OrderingDto;

@Component
public class DelivererDtoToDeliverer implements Converter<DelivererDto, Deliverer>{
	
	@Autowired
	private DelivererService delivererService;
	
	@Autowired 
	private OrderingService orderingService;

	@Override
	public Deliverer convert(DelivererDto source) {
		
		Deliverer deliverer = null;
		if(source.getId() == null) {
			deliverer = new Deliverer();
		} else {
			deliverer = delivererService.findOne(source.getId());
		}
		if(deliverer != null) {
			deliverer.setId(source.getId());
			deliverer.setIdNumber(source.getIdNumber());
			deliverer.setNameSurname(source.getNameSurname());
			deliverer.setPersonalNumber(source.getPersonalNumber());
			
			List<Long> idOrders = source.getOrders().stream().map(OrderingDto::getId).collect(Collectors.toList());
			List<Ordering> orders = orderingService.find(idOrders);
			deliverer.setOrders(new HashSet<>(orders));
			
		}
		return deliverer;
	}
	

}
