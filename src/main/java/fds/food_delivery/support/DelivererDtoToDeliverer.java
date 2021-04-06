package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.web.dto.DelivererDto;

@Component
public class DelivererDtoToDeliverer implements Converter<DelivererDto, Deliverer>{

	@Override
	public Deliverer convert(DelivererDto source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
