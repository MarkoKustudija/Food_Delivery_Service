package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Order;
import fds.food_delivery.web.dto.OrderDto;

@Component
public class OrderToOrderDto implements Converter<Order, OrderDto> {

	@Override
	public OrderDto convert(Order source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
