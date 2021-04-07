package fds.food_delivery.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Ordering;
import fds.food_delivery.web.dto.OrderingDto;

@Component
public class OrderingToOrderingDto implements Converter<Ordering, OrderingDto> {

	@Override
	public OrderingDto convert(Ordering source) {
		OrderingDto dto = new OrderingDto();
		dto.setId(source.getId());
		dto.setOrderDate(source.getOrderDate().toString());
		dto.setOrderNumber(source.getOrderNumber());
		dto.setPrice(source.getPrice());
		dto.setDescription(source.getDescription());
		dto.setDeliveryAddress(source.getDeliveryAddress());
		
		dto.setBillId(source.getBill().getId());
		dto.setDelivererId(source.getDeliverer().getId());
		
		return dto;
	}

	public List<OrderingDto> convert(List<Ordering> orders) {
		List<OrderingDto> orderingDtos = new ArrayList<>();
		for(Ordering o : orders) {
			orderingDtos.add(convert(o));
		}
		return orderingDtos;
	}

	
	

}
