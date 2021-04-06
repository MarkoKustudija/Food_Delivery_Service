package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Order;
import fds.food_delivery.web.dto.OrderDto;

@Component
public class OrderDtoToOrder implements Converter<OrderDto, Order>{

	@Override
	public Order convert(OrderDto source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
